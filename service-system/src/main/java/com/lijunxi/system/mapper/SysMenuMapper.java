package com.lijunxi.system.mapper;

import com.lijunxi.model.system.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author lijunxi
 * @since 2025-02-10
 */

@Repository
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

}
