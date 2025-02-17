package com.lijunxi.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijunxi.model.system.SysPost;
import com.lijunxi.model.system.SysUser;
import com.lijunxi.model.vo.SysPostQueryVo;
import com.lijunxi.system.mapper.SysPostMapper;
import com.lijunxi.system.service.ISysPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author lijunxi
 * @since 2025-02-17
 */
@Service
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements ISysPostService {

    @Autowired
    private SysPostMapper sysPostMapper;


    @Override
    public IPage<SysPost> selectPage(Page<SysUser> pageParams, SysPostQueryVo sysPostQueryVo) {
        return sysPostMapper.selectPage(pageParams,sysPostQueryVo);
    }
}
