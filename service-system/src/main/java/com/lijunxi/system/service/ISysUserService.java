package com.lijunxi.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lijunxi.model.system.SysUser;
import com.lijunxi.model.vo.SysUserAddVo;
import com.lijunxi.model.vo.SysUserQueryVo;

import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lijunxi
 * @since 2025-02-09
 */
public interface ISysUserService extends IService<SysUser> {

    IPage<SysUser> selectPage(Page<SysUser> pageParams, SysUserQueryVo sysUserQueryVo);

    boolean save(SysUserAddVo sysUserAddVo);

    SysUser getUserInfoByUserName(String username);

    Map<String, Object> getUserInfo(String username);
}
