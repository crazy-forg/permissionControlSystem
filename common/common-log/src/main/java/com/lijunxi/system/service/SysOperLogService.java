package com.lijunxi.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lijunxi.model.system.SysOperLog;
import com.lijunxi.model.vo.SysOperLogQueryVo;
import org.apache.ibatis.annotations.Param;

public interface SysOperLogService  {

    IPage<SysOperLog> selectPage(Page<SysOperLog> pageParam,@Param("vo") SysOperLogQueryVo sysOperLogQueryVo);

    void saveSysLog(SysOperLog operLog);

    SysOperLog getById(Long id);
}
