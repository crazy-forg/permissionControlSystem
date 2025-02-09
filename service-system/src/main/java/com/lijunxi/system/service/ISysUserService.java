package com.lijunxi.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lijunxi.model.system.SysUser;
import com.lijunxi.model.vo.SysUserQueryVo;

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
}
