package com.lijunxi.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijunxi.model.system.SysOperLog;
import com.lijunxi.model.vo.SysOperLogQueryVo;
import com.lijunxi.system.mapper.SysOperLogMapper;
//import com.lijunxi.system.service.ISysOperLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lijunxi.system.service.SysOperLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author lijunxi
 * @since 2025-03-15
 */

@Service
public class SysOperLogServiceImpl implements SysOperLogService {
    @Resource
    private SysOperLogMapper sysOperLogMapper;


    @Override
    public IPage<SysOperLog> selectPage(Page<SysOperLog> pageParam, SysOperLogQueryVo sysOperLogQueryVo) {
       return sysOperLogMapper.selectPage(pageParam, sysOperLogQueryVo);
    }

    @Override
    public void saveSysLog(SysOperLog operLog) {
        sysOperLogMapper.insert(operLog);
    }

    @Override
    public SysOperLog getById(Long id) {
        return sysOperLogMapper.selectById(id);
    }

}
