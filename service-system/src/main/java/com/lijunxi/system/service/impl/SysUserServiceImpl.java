package com.lijunxi.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijunxi.model.system.SysUser;
import com.lijunxi.model.vo.RouterVo;
import com.lijunxi.model.vo.SysUserAddVo;
import com.lijunxi.model.vo.SysUserQueryVo;
import com.lijunxi.system.mapper.SysUserMapper;
import com.lijunxi.system.service.ISysMenuService;
import com.lijunxi.system.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lijunxi
 * @since 2025-02-09
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Autowired
    private ISysMenuService sysMenuService;

    @Override
    public IPage<SysUser> selectPage(Page<SysUser> pageParams, SysUserQueryVo sysUserQueryVo) {
        return baseMapper.selectPage(pageParams, sysUserQueryVo);
    }

    @Override
    public boolean save(SysUserAddVo sysUserAddVo) {
        return baseMapper.insert(sysUserAddVo);
    }

    @Override
    public SysUser getUserInfoByUserName(String username) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public Map<String, Object> getUserInfo(String username) {
        // 根据用户名称查询基本信息
        SysUser userInfoByUserName = this.getUserInfoByUserName(username);

        // 根据userId查询菜单权限
        List<RouterVo> routerVoList = sysMenuService.getUserMenuList(userInfoByUserName.getId());

        // 根据userid查询按钮权限
        List<String> permsList = sysMenuService.getUserButtonList(userInfoByUserName.getId());

        Map<String, Object> result = new HashMap<>();
        result.put("name", userInfoByUserName.getName());
        result.put("avatar", userInfoByUserName.getHeadUrl());

        ArrayList<String > permsArray = new ArrayList<>();
        permsArray.add("admin");
        result.put("roles", permsArray);
        // 路由权限
        result.put("routers", routerVoList);
        // 按钮权限
        result.put("buttons", permsList);
        return result;
    }
}
