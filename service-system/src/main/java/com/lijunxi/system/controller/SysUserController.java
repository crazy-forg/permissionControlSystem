package com.lijunxi.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lijunxi.common.result.Result;
import com.lijunxi.model.system.SysUser;
import com.lijunxi.model.vo.SysUserAddVo;
import com.lijunxi.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/admin/system/sysUser")
@CrossOrigin
public class SysUserController {

    private final SysUserService sysUserService;

    @Autowired
    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }


    @ApiOperation("添加用户")
    @PostMapping("addUser")
    public Result<?> addUser(@RequestBody SysUserAddVo sysUserAddVo) {
        QueryWrapper<SysUser> queryUserWrapper = new QueryWrapper<>();

        queryUserWrapper.eq("username", sysUserAddVo.getUsername());
        int count = sysUserService.count(queryUserWrapper);
        if (count > 0) {
            return Result.fail().message("用户名已存在");
        }

        QueryWrapper<SysUser> queryUserPhoneWrapper = new QueryWrapper<>();
        queryUserPhoneWrapper.eq("phone", sysUserAddVo.getPhone());
        int count1 = sysUserService.count(queryUserPhoneWrapper);
        if (count1 > 0) {
            return Result.fail().message("手机号已存在");
        }

        boolean isSuccess = sysUserService.save(sysUserAddVo);

        return isSuccess ? Result.ok() : Result.fail();
    }
}
