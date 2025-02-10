package com.lijunxi.system.mapper;

import com.lijunxi.model.system.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户角色 Mapper 接口
 * </p>
 *
 * @author lijunxi
 * @since 2025-02-10
 */
@Repository
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

}
