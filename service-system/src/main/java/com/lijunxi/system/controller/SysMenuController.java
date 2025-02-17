package com.lijunxi.system.controller;


import com.lijunxi.common.result.Result;
import com.lijunxi.model.system.SysMenu;
import com.lijunxi.model.vo.AssginMenuVo;
import com.lijunxi.system.service.ISysMenuService;
import com.lijunxi.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author lijunxi
 * @since 2025-02-10
 */
@Api(tags = "菜单管理")
@RestController
@RequestMapping("/admin/system/sysMenu")
public class SysMenuController {

    private final ISysMenuService sysMenuService;

    @Autowired
    public SysMenuController(ISysMenuService sysMenuService) {
        this.sysMenuService = sysMenuService;
    }

    @ApiOperation(value = "获取菜单")
    @GetMapping("findNodes")
    public Result<?> findNodes() {
        List<SysMenu> list = sysMenuService.findNodes();
        return Result.ok(list);
    }

    @ApiOperation(value = "新增菜单")
    @PostMapping("save")
    public Result<?> save(@RequestBody SysMenu permission) {
        boolean isSuccess =  sysMenuService.save(permission);
        return isSuccess ? Result.ok() : Result.fail();
    }

    @ApiOperation(value = "修改菜单")
    @PostMapping("update")
    public Result<?> updateById(@RequestBody SysMenu permission) {
        boolean isSuccess = sysMenuService.updateById(permission);
        return isSuccess ? Result.ok() : Result.fail();
    }

    @ApiOperation(value = "删除菜单")
    @DeleteMapping("remove/{id}")
    public Result<?> remove(@PathVariable String id) {
        boolean isSuccess = sysMenuService.removeById(id);
        return isSuccess ? Result.ok() : Result.fail();
    }

    @ApiOperation(value = "根据角色获取菜单")
    @GetMapping("/toAssign/{roleId}")
    public Result<?> toAssign(@PathVariable String roleId) {
        List<SysMenu> list = sysMenuService.findSysMenuByRoleId(roleId);
        return Result.ok(list);
    }

    @ApiOperation(value = "给角色分配权限")
    @PostMapping("/doAssign")
    public Result<?> doAssign(@RequestBody AssginMenuVo assginMenuVo) {
        sysMenuService.doAssign(assginMenuVo);
        return Result.ok();
    }

}
