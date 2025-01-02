package com.lijunxi.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lijunxi.model.system.SysUser;
import com.lijunxi.model.vo.SysUserAddVo;



public interface SysUserService extends IService<SysUser>  {
    boolean save(SysUserAddVo sysUserAddVo);


}
