package com.lijunxi.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijunxi.model.system.SysPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lijunxi.model.system.SysUser;
import com.lijunxi.model.vo.SysPostQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
    IPage<SysPost> selectPage(Page<SysUser> page, @Param("vo") SysPostQueryVo sysUserQueryVo);
}
