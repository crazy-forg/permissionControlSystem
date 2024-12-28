package com.lijunxi.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijunxi.model.system.SysRole;

import com.lijunxi.model.vo.SysRoleQueryVo;
import com.lijunxi.system.mapper.SysRoleMapper;
import com.lijunxi.system.service.SysRoleService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;



@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public IPage<SysRole> selectPage(Page<SysRole> pageParams, SysRoleQueryVo sysRoleQueryVo) {
        return baseMapper.selectPage(pageParams,sysRoleQueryVo);
    }

    @Override
    public SysRole selectOne(Long id) {
        return baseMapper.selectById(id);
    }
}