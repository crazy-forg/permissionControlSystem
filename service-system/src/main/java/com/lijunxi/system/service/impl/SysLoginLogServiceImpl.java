package com.lijunxi.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lijunxi.model.system.SysLoginLog;
import com.lijunxi.model.vo.SysLoginLogQueryVo;
import com.lijunxi.system.mapper.SysLoginLogMapper;
import com.lijunxi.system.service.SysLoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class SysLoginLogServiceImpl extends ServiceImpl<SysLoginLogMapper, SysLoginLog> implements SysLoginLogService {

    @Resource
    private SysLoginLogMapper sysLoginLogMapper;

    @Override
    public IPage<SysLoginLog> selectPage(Page<SysLoginLog> pageParam, SysLoginLogQueryVo sysLoginLogQueryVo) {
        return sysLoginLogMapper.selectPage(pageParam, sysLoginLogQueryVo);
    }
}