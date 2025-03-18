package com.lijunxi.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lijunxi.model.system.SysLoginLog;
import com.lijunxi.model.vo.SysLoginLogQueryVo;
import com.lijunxi.system.mapper.SysLoginLogMapper;
import com.lijunxi.system.service.SysLoginLogService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SysLoginLogServiceImpl extends ServiceImpl<SysLoginLogMapper, SysLoginLog> implements SysLoginLogService {

    @Resource
    private SysLoginLogMapper sysLoginLogMapper;



    @Override
    public IPage<SysLoginLog> pageQuery(SysLoginLogQueryVo queryVo) {
        // 分页参数
        int pageNum = StringUtils.hasText(queryVo.getPageNum()) ? Integer.parseInt(queryVo.getPageNum()) : 1;
        int pageSize = StringUtils.hasText(queryVo.getPageSize()) ? Integer.parseInt(queryVo.getPageSize()) : 10;
        Page<SysLoginLog> page = new Page<>(pageNum, pageSize);

        // 查询条件
        LambdaQueryWrapper<SysLoginLog> wrapper = new LambdaQueryWrapper<>();

        // 用户名筛选（精确匹配）
        if (StringUtils.hasText(queryVo.getUsername())) {
            wrapper.eq(SysLoginLog::getUsername, queryVo.getUsername());
        }

        // 创建时间范围条件（将 String 转换为 Date）
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if (StringUtils.hasText(queryVo.getCreateTimeBegin())) {
                Date beginDate = sdf.parse(queryVo.getCreateTimeBegin());
                wrapper.ge(SysLoginLog::getCreateTime, beginDate);
            }
            if (StringUtils.hasText(queryVo.getCreateTimeEnd())) {
                Date endDate = sdf.parse(queryVo.getCreateTimeEnd());
                wrapper.le(SysLoginLog::getCreateTime, endDate);
            }
        } catch (Exception e) {
            throw new RuntimeException("时间格式错误，请使用 yyyy-MM-dd HH:mm:ss");
        }

        // 默认按创建时间降序排序
        wrapper.orderByDesc(SysLoginLog::getCreateTime);

        // 执行分页查询
        return this.page(page, wrapper);
    }


}