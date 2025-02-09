package com.lijunxi.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijunxi.model.system.SysUser;
import com.lijunxi.model.vo.SysUserAddVo;
import com.lijunxi.model.vo.SysUserQueryVo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    boolean insert(SysUserAddVo sysUserAddVo);



    IPage<SysUser> selectPage(Page<SysUser> page, @Param("vo") SysUserQueryVo sysUserQueryVo);

}
