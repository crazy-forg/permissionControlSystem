package com.lijunxi.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijunxi.common.result.Result;

import com.lijunxi.common.utils.MD5;
import com.lijunxi.model.system.SysUser;
import com.lijunxi.model.vo.SysUserQueryVo;
import com.lijunxi.system.annotation.Log;
import com.lijunxi.system.enums.BusinessType;
import com.lijunxi.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author lijunxi
 * @since 2025-02-09
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/admin/system/sysUser")
public class SysUserController {

    private final ISysUserService sysUserService;

    @Autowired
    public SysUserController(ISysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    /**
     * 分页查询
     *
     * @param sysUserQueryVo 查询条件对象，包含查询所需的信息
     * @return 分页查询结果
     */
    @PreAuthorize("hasAuthority('bnt.sysUser.list')")
    @ApiOperation("分页查询")
    @GetMapping("selectPage")
    public Result<?> findQueryUser(SysUserQueryVo sysUserQueryVo) {
        // 创建page
        Long pageNum = sysUserQueryVo.getPageNum();
        Long pageSize = sysUserQueryVo.getPageSize();
        Page<SysUser> pageParams = new Page<>(pageNum, pageSize);
        IPage<SysUser> pageModel = sysUserService.selectPage(pageParams, sysUserQueryVo);
        return Result.ok(pageModel);
    }

    /**
     * 查询所有记录
     *
     * @return 所有用户列表
     */
    @PreAuthorize("hasAuthority('bnt.sysUser.list')")
    @ApiOperation("查询所有用户")
    @GetMapping("findAll")
    public Result<?> findAll() {
        //调用service
        List<SysUser> list = sysUserService.list();
        return Result.ok(list);

    }


    /**
     * @param id 用户id
     * @return 用户信息
     */
    @PreAuthorize("hasAuthority('bnt.sysUser.list')")
    @ApiOperation("根据id查询")
    @GetMapping("getUser/{id}")
    public Result<?> findById(@PathVariable String id) {
        SysUser sysUser = sysUserService.getById(id);
        return Result.ok(sysUser);
    }

    /**
     * @param id 用户id
     * @return 结果
     */
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PreAuthorize("hasAuthority('bnt.sysUser.remove')")
    @ApiOperation("根据id删除")
    @DeleteMapping("remove/{id}")
    public Result<?> removeUser(@PathVariable String id) {
        boolean isSuccess = sysUserService.removeById(id);
        return isSuccess ? Result.ok() : Result.fail();
    }

    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PreAuthorize("hasAuthority('bnt.sysUser.update')")
    @ApiOperation(value = "更新用户")
    @PostMapping("/update")
    public Result<?> updateById(@RequestBody SysUser user) {
        sysUserService.updateById(user);
        return Result.ok();
    }

    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PreAuthorize("hasAuthority('bnt.sysUser.add')")
    @ApiOperation("添加用户")
    @PostMapping("addUser")
    public Result<?> addUser(@RequestBody SysUser sysUser) {
        QueryWrapper<SysUser> queryUserWrapper = new QueryWrapper<>();

        queryUserWrapper.eq("username", sysUser.getUsername());
        int count = sysUserService.count(queryUserWrapper);
        if (count > 0) {
            return Result.fail().message("用户名已存在");
        }

        QueryWrapper<SysUser> queryUserPhoneWrapper = new QueryWrapper<>();
        queryUserPhoneWrapper.eq("phone", sysUser.getPhone());
        int count1 = sysUserService.count(queryUserPhoneWrapper);
        if (count1 > 0) {
            return Result.fail().message("手机号已存在");
        }

        // 对密码进行加密
        String encryptPassword = MD5.encrypt(sysUser.getPassword());
        sysUser.setPassword(encryptPassword);

        boolean isSuccess = sysUserService.save(sysUser);

        return isSuccess ? Result.ok() : Result.fail();
    }

}
