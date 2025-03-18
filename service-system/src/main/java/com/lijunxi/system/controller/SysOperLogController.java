package com.lijunxi.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijunxi.common.result.Result;
import com.lijunxi.model.system.SysOperLog;
import com.lijunxi.model.vo.SysOperLogQueryVo;
import com.lijunxi.system.service.SysOperLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 操作日志记录 前端控制器
 * </p>
 *
 * @author lijunxi
 * @since 2025-03-15
 */
@Api(tags = "操作日志管理")
@RestController
@RequestMapping("/admin/system/sysOperLog")
public class SysOperLogController {

    @Resource
    private SysOperLogService sysOperLogService;


    @ApiOperation(value = "获取分页列表")
    @GetMapping("/page")
    public Result<IPage<SysOperLog>> pageQuery(SysOperLogQueryVo queryVo) {
        IPage<SysOperLog> pageResult = sysOperLogService.pageQuery(queryVo);
        return Result.ok(pageResult);
    }

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SysOperLog sysOperLog = sysOperLogService.getById(id);
        return Result.ok(sysOperLog);
    }

}
