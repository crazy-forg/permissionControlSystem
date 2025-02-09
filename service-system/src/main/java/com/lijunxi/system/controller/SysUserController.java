package com.lijunxi.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijunxi.common.result.Result;

import com.lijunxi.model.system.SysUser;
import com.lijunxi.model.vo.SysUserQueryVo;
import com.lijunxi.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
     * @return
     */
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
    @ApiOperation("查询所有用户")
    @GetMapping("findAll")
    public Result<?> findAll() {
        //调用service
        List<SysUser> list = sysUserService.list();
        return Result.ok(list);

    }

}
