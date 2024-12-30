package com.lijunxi.system.controller;


import com.lijunxi.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags="用户登录")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result<?> login() {
        Map<String, Object> map = new HashMap<>();
        map.put("token", "admin");
        return Result.ok(map);

    }

    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public Result<?> info() {
        Map<String, Object> map = new HashMap<>();
        map.put("roles", "[admin]");
        map.put("name", "admin");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return Result.ok(map);

    }

    @ApiOperation("登出")
    @PostMapping("/logout")
    public Result<?> logout() {

        return Result.ok();
    }
}
