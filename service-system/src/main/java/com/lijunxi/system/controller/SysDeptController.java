package com.lijunxi.system.controller;


import com.lijunxi.common.result.Result;
import com.lijunxi.model.system.SysDept;
import com.lijunxi.model.system.SysMenu;
import com.lijunxi.system.service.ISysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "新增部门")
    @PostMapping("/save")
    public Result<String> saveDept(@RequestBody SysDept sysDept) {
        sysDeptService.saveDept(sysDept);
        return Result.ok("部门新增成功");
    }

    @ApiOperation(value = "更新部门")
    @PutMapping("/update")
    public Result<String> updateDept(@RequestBody SysDept sysDept) {
        sysDeptService.updateDept(sysDept);
        return Result.ok("部门更新成功");
    }

    @ApiOperation(value = "删除部门")
    @DeleteMapping("/remove/{id}")
    public Result<String> removeDept(@PathVariable Long id) {
        sysDeptService.removeDept(id);
        return Result.ok("部门删除成功");
    }

}
