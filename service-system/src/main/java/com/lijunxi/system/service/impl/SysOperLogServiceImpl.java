package com.lijunxi.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
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
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements SysOperLogService {
    @Resource
    private SysOperLogMapper sysOperLogMapper;


    @Override
    public void saveSysLog(SysOperLog operLog) {
        sysOperLogMapper.insert(operLog);
    }

    @Override
    public SysOperLog getById(Long id) {
        return sysOperLogMapper.selectById(id);
    }

    @Override
    public IPage<SysOperLog> pageQuery(SysOperLogQueryVo queryVo) {
        // 分页参数
        int pageNum = StringUtils.hasText(queryVo.getPageNum()) ? Integer.parseInt(queryVo.getPageNum()) : 1;
        int pageSize = StringUtils.hasText(queryVo.getPageSize()) ? Integer.parseInt(queryVo.getPageSize()) : 10;
        Page<SysOperLog> page = new Page<>(pageNum, pageSize);

        // 查询条件
        LambdaQueryWrapper<SysOperLog> wrapper = new LambdaQueryWrapper<>();

        // 按 title 筛选
        if (StringUtils.hasText(queryVo.getTitle())) {
            wrapper.eq(SysOperLog::getTitle, queryVo.getTitle());
        }

        // 按 operName 筛选
        if (StringUtils.hasText(queryVo.getOperName())) {
            wrapper.eq(SysOperLog::getOperName, queryVo.getOperName());
        }

        // 创建时间范围条件
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if (StringUtils.hasText(queryVo.getCreateTimeBegin())) {
                Date beginDate = sdf.parse(queryVo.getCreateTimeBegin());
                wrapper.ge(SysOperLog::getCreateTime, beginDate);
            }
            if (StringUtils.hasText(queryVo.getCreateTimeEnd())) {
                Date endDate = sdf.parse(queryVo.getCreateTimeEnd());
                wrapper.le(SysOperLog::getCreateTime, endDate);
            }
        } catch (Exception e) {
            throw new RuntimeException("时间格式错误，请使用 yyyy-MM-dd HH:mm:ss");
        }

        // 默认按创建时间降序排序
        wrapper.orderByDesc(SysOperLog::getCreateTime);

        // 执行分页查询
        return this.page(page, wrapper);
    }

}
