package com.lijunxi.system.service;

import com.lijunxi.model.system.SysRole;
import com.lijunxi.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;


public interface SysRoleService extends IService<SysRole> {

    IPage<SysRole> selectPage(Page<SysRole> pageParams, SysRoleQueryVo sysRoleQueryVo);
}
