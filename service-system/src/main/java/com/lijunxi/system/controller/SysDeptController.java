package com.lijunxi.system.controller;


import com.lijunxi.common.result.Result;
import com.lijunxi.model.system.SysDept;
import com.lijunxi.model.system.SysMenu;
import com.lijunxi.system.service.ISysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 组织机构 前端控制器
 * </p>
 *
 * @author lijunxi
 * @since 2025-03-15
 */
@Api( tags = "部门管理")
@RestController
@RequestMapping("/admin/system/sysDept")
public class SysDeptController {

   final private ISysDeptService sysDeptService;

    public SysDeptController(ISysDeptService sysDeptService) {
        this.sysDeptService = sysDeptService;
    }


    @ApiOperation(value = "获取部门")
    @GetMapping("getDeptTree")
    public Result<?> findNodes() {
        List<SysDept> list = sysDeptService.getDeptTree();
        return Result.ok(list);
    }

}
