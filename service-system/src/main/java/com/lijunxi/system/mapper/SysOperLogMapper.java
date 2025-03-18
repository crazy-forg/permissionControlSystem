package com.lijunxi.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijunxi.model.system.SysOperLog;
import com.lijunxi.model.vo.SysOperLogQueryVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 操作日志记录 Mapper 接口
 * </p>
 *
 * @author lijunxi
 * @since 2025-03-15
 */
public interface SysOperLogMapper extends BaseMapper<SysOperLog> {
//    IPage<SysOperLog> selectPage(Page<SysOperLog> page, @Param("vo") SysOperLogQueryVo sysOperLogQueryVo);
}
