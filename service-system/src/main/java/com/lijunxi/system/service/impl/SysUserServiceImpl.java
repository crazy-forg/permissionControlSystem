package com.lijunxi.system.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijunxi.model.system.SysUser;
import com.lijunxi.model.vo.SysUserQueryVo;
import com.lijunxi.system.mapper.SysUserMapper;
import com.lijunxi.system.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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


    @Override
    public IPage<SysUser> selectPage(Page<SysUser> pageParams, SysUserQueryVo sysUserQueryVo) {
        return baseMapper.selectPage(pageParams, sysUserQueryVo);
    }
}
