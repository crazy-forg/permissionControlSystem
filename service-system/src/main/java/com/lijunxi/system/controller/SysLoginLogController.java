package com.lijunxi.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijunxi.common.result.Result;
import com.lijunxi.model.system.SysLoginLog;
import com.lijunxi.model.vo.SysLoginLogQueryVo;
import com.lijunxi.system.service.SysLoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api( tags = "登录日志管理")
@RestController
@RequestMapping(value="/admin/system/sysLoginLog")
public class SysLoginLogController {

    @Resource
    private SysLoginLogService sysLoginLogService;

    @ApiOperation(value = "获取分页列表")
    @GetMapping("/list")
    public Result<IPage<SysLoginLog>> pageQuery(SysLoginLogQueryVo queryVo) {
        IPage<SysLoginLog> pageResult = sysLoginLogService.pageQuery(queryVo);
        return Result.ok(pageResult);
    }

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result<?> getById(@PathVariable String id) {
        SysLoginLog sysLoginLog = sysLoginLogService.getById(id);
        return Result.ok(sysLoginLog);
    }
}
