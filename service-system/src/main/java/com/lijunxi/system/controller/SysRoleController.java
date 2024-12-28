package com.lijunxi.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijunxi.common.result.Result;
import com.lijunxi.model.system.SysRole;
import com.lijunxi.model.vo.SysRoleQueryVo;
import com.lijunxi.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    @Autowired
    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    // 修改角色
    @ApiOperation("修改角色")
    @PostMapping("updateRole")
    public Result<?> updateRole(@RequestBody SysRole role) {
        SysRole sysRole = sysRoleService.selectOne(Long.valueOf(role.getId()));
        if (sysRole != null) {
            sysRole.setRoleName(role.getRoleName());
            sysRole.setRoleCode(role.getRoleCode());
            sysRole.setDescription(role.getDescription());
            boolean isSuccess = sysRoleService.updateById(sysRole);
            return isSuccess ? Result.ok() : Result.fail();
        }

        return Result.fail("角色不存在");

    }

    // 新增角色
    @ApiOperation("添加角色")
    @PostMapping("addRole")
    public Result<?> addRole(@RequestBody SysRole sysRole) {
        boolean isSuccess = sysRoleService.save(sysRole);
        return isSuccess ? Result.ok() : Result.fail();
    }

    // 查询所有记录
    @ApiOperation("查询所有角色")
    @GetMapping("findAll")
    public Result<?> findAll() {
        //调用service
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }

    // 分页查询
    @ApiOperation("分页查询")
    @GetMapping("{pageNum}/{pageSize}")
    public Result<?> findQueryRole(@PathVariable Long pageNum, @PathVariable Long pageSize, SysRoleQueryVo sysRoleQueryVo) {
        // 创建page
        Page<SysRole> pageParams = new Page<>(pageNum, pageSize);
        IPage<SysRole> pageModel = sysRoleService.selectPage(pageParams, sysRoleQueryVo);
        return Result.ok(pageModel);
    }

    // 删除角色
    @ApiOperation("删除角色")
    @DeleteMapping("remove/{id}")
    public Result<?> remove(@PathVariable("id") Long id) {
        boolean isSuccess = sysRoleService.removeById(id);
        return isSuccess ? Result.ok() : Result.fail();
    }
}
