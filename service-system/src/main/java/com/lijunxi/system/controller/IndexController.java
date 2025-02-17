package com.lijunxi.system.controller;


import com.lijunxi.common.result.Result;
import com.lijunxi.common.result.ResultCodeEnum;
import com.lijunxi.common.utils.JwtHelper;
import com.lijunxi.common.utils.MD5;
import com.lijunxi.model.system.SysUser;
import com.lijunxi.model.vo.LoginVo;
import com.lijunxi.system.exception.CustomException;
import com.lijunxi.system.exception.GlobalExceptionHandler;
import com.lijunxi.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "用户登录")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {

    @Autowired
    private ISysUserService sysUserService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result<?> login(@RequestBody LoginVo loginVo) {

        // 根据用户名称查询，看是否存在
        SysUser sysUser = sysUserService.getUserInfoByUserName(loginVo.getUsername());
        // 不存在
        if (sysUser == null) {
            throw new CustomException(ResultCodeEnum.LOGIN_MOBLE_ERROR.getCode(), ResultCodeEnum.LOGIN_MOBLE_ERROR.getMessage());
        }

        // 判断密码是否一致
        String loginVoPassword = loginVo.getPassword();
        String encryptLoginPassword = MD5.encrypt(loginVoPassword);

        if (!sysUser.getPassword().equals(encryptLoginPassword)) {
            throw new CustomException(ResultCodeEnum.PASSWORD_ERROR.getCode(), ResultCodeEnum.PASSWORD_ERROR.getMessage());
        }

        // 判断用户是否可用
        if (sysUser.getStatus() == 0) {
            throw new CustomException(ResultCodeEnum.ACCOUNT_STOP.getCode(), ResultCodeEnum.ACCOUNT_STOP.getMessage());
        }

        // 根据用户id和名称生成token
        String token = JwtHelper.createToken(sysUser.getId(), sysUser.getUsername());

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        return Result.ok(map);

    }

    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public Result<?> info(HttpServletRequest request) {
        // 获取token
        String token = request.getHeader("token");

        // 从token中获取用户名称（Id）
        String username = JwtHelper.getUsername(token);

        // 根据用户名称获取用户信息
        Map<String, Object> map = sysUserService.getUserInfo(username);

//        Map<String, Object> map  new HashMap<>();
//        map.put("roles", "[admin]");
//        map.put("name", "admin");
//        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return Result.ok(map);

    }

    @ApiOperation("登出")
    @PostMapping("/logout")
    public Result<?> logout() {

        return Result.ok();
    }
}
