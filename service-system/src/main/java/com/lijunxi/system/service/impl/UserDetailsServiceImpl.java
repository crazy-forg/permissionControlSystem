package com.lijunxi.system.service.impl;

import com.lijunxi.model.system.SysUser;
import com.lijunxi.system.custom.CustomUser;
import com.lijunxi.system.mapper.SysUserMapper;
import com.lijunxi.system.service.ISysMenuService;
import com.lijunxi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ISysUserService sysUserService;
    private final ISysMenuService sysMenuService;

    @Autowired
    public UserDetailsServiceImpl(ISysUserService sysUserService, ISysMenuService sysMenuService) {
        this.sysUserService = sysUserService;
        this.sysMenuService = sysMenuService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.getUserInfoByUserName(username);
        if (null == sysUser) {
            throw new UsernameNotFoundException("用户名不存在！");
        }

        if (sysUser.getStatus() == 0) {
            throw new RuntimeException("账号已停用");
        }

        List<String> userPermsList = sysMenuService.getUserButtonList(sysUser.getId());
        // 转换为security要求的数据格式
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String perm : userPermsList) {
            authorities.add(new SimpleGrantedAuthority(perm.trim()));
        }
        return new CustomUser(sysUser, authorities);
    }
}