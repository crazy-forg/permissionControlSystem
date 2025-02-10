package com.lijunxi.system.service;

import com.lijunxi.model.system.SysRole;
import com.lijunxi.model.vo.AssginRoleVo;
import com.lijunxi.model.vo.SysRoleAddVo;
import com.lijunxi.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;


public interface SysRoleService extends IService<SysRole> {

    IPage<SysRole> selectPage(Page<SysRole> pageParams, SysRoleQueryVo sysRoleQueryVo);

    SysRole selectOne(Long id);

    boolean save(SysRoleAddVo sysRoleAddVo);

    Map<String, Object> getRolesByUserId(String userId);

    void doAssign(AssginRoleVo assginRoleVo);
}
