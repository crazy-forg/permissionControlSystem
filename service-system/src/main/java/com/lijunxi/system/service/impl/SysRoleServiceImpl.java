package com.lijunxi.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijunxi.model.system.SysRole;

import com.lijunxi.model.system.SysUserRole;
import com.lijunxi.model.vo.AssginRoleVo;
import com.lijunxi.model.vo.SysRoleAddVo;
import com.lijunxi.model.vo.SysRoleQueryVo;
import com.lijunxi.system.mapper.SysRoleMapper;
import com.lijunxi.system.mapper.SysUserRoleMapper;
import com.lijunxi.system.service.SysRoleService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    private final SysRoleMapper sysRoleMapper;
    private final SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    public SysRoleServiceImpl(SysRoleMapper sysRoleMapper, SysUserRoleMapper sysUserRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
        this.sysUserRoleMapper = sysUserRoleMapper;
    }


    @Override
    public IPage<SysRole> selectPage(Page<SysRole> pageParams, SysRoleQueryVo sysRoleQueryVo) {
        return baseMapper.selectPage(pageParams, sysRoleQueryVo);
    }

    @Override
    public SysRole selectOne(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public boolean save(SysRoleAddVo sysRoleAddVo) {
        return baseMapper.insert(sysRoleAddVo);
    }

    // 获取用户的角色数据
    @Override
    public Map<String, Object> getRolesByUserId(String userId) {

        // 获取所有角色
        List<SysRole> roles = baseMapper.selectList(null);

        // 根据用户id查询
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectList(queryWrapper);

        // 从sysUserRoles集合里面获取所有的角色id
        List<String> roleIds = new ArrayList<>();
        for (SysUserRole sysUserRole : sysUserRoles) {
            String roleId = sysUserRole.getRoleId();
            roleIds.add(roleId);
        }

        // 封装到map集合
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("allRoles", roles);
        returnMap.put("roleIds", roleIds);

        return returnMap;
    }

    @Override
    @Transactional
    public void doAssign(AssginRoleVo assginRoleVo) {
        // 根据用户id删除之前的角色
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", assginRoleVo.getUserId());
        sysUserRoleMapper.delete(queryWrapper);

        // 获取所有角色id，添加到角色用户关系表

        // 获取角色id列表
        List<String> roleIdList = assginRoleVo.getRoleIdList();
        for (String roleId : roleIdList) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(assginRoleVo.getUserId());
            sysUserRole.setRoleId(roleId);

            // save roles
            sysUserRoleMapper.insert(sysUserRole);
        }


    }

}