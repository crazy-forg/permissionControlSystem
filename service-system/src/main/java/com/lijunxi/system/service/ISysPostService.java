package com.lijunxi.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijunxi.model.system.SysPost;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lijunxi.model.system.SysUser;
import com.lijunxi.model.vo.SysPostQueryVo;

/**
 * <p>
 * 岗位信息表 服务类
 * </p>
 *
 * @author lijunxi
 * @since 2025-02-17
 */
public interface ISysPostService extends IService<SysPost> {

    IPage<SysPost> selectPage(Page<SysUser> pageParams, SysPostQueryVo sysPostQueryVo);
}
