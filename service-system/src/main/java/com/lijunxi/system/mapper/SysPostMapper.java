package com.lijunxi.system.mapper;

import com.lijunxi.model.system.SysPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 岗位信息表 Mapper 接口
 * </p>
 *
 * @author lijunxi
 * @since 2025-02-17
 */
@Repository
@Mapper
public interface SysPostMapper extends BaseMapper<SysPost> {

}
