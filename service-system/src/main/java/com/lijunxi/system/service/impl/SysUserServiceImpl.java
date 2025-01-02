package com.lijunxi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lijunxi.model.system.SysUser;
import com.lijunxi.model.vo.SysUserAddVo;
import com.lijunxi.system.mapper.SysUserMapper;
import com.lijunxi.system.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Override
    public boolean save(SysUserAddVo sysUserAddVo) {
        return baseMapper.insert(sysUserAddVo);
    }
}
