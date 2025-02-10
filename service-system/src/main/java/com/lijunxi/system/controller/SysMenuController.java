package com.lijunxi.system.controller;


import com.lijunxi.common.result.Result;
import com.lijunxi.model.system.SysMenu;
import com.lijunxi.system.service.ISysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author lijunxi
 * @since 2025-02-10
 */
@Api(tags ="菜单管理")
@RestController
@RequestMapping("/admin/system/sysMenu")
public class SysMenuController {
    @Autowired
    private ISysMenuService sysMenuService;


    @ApiOperation(value = "获取菜单")
    @GetMapping("findNodes")
    public Result<?> findNodes() {
        List<SysMenu> list = sysMenuService.findNodes();
        return Result.ok(list);
    }

}
