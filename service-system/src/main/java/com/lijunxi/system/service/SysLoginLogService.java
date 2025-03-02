package com.lijunxi.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lijunxi.model.system.SysLoginLog;
import com.lijunxi.model.vo.SysLoginLogQueryVo;

public interface SysLoginLogService extends IService<SysLoginLog> {
    //列表显示
    IPage<SysLoginLog> selectPage(Page<SysLoginLog> pageParam, SysLoginLogQueryVo sysLoginLogQueryVo);
}