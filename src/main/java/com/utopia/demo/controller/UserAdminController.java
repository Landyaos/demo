package com.utopia.demo.controller;


import com.utopia.demo.common.CommonResult;
import com.utopia.demo.entity.User;
import com.utopia.demo.service.UserAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.hibernate.loader.plan.build.internal.LoadGraphLoadPlanBuildingStrategy;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Api(value = "UserAdminController")
@RestController
public class UserAdminController {

    @Autowired
    private UserAdminService userAdminService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @GetMapping("/auth")
    public void auth() {
        System.out.println("auth test");
    }


    @ApiOperation(value = "Register", httpMethod = "POST", response = CommonResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataTypeClass = String.class, required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataTypeClass = String.class, required = true),
            @ApiImplicitParam(name = "mail", value = "邮箱", dataTypeClass = String.class, required = true),
            @ApiImplicitParam(name = "phone", value = "电话", dataTypeClass = String.class, required = true)
    })
    @PostMapping(value = "/register")
    public CommonResult<User> register(@RequestParam("username") String username,
                                       @RequestParam("password") String password,
                                       @RequestParam("mail") String mail,
                                       @RequestParam("phone") String phone) {

        User user_new = userAdminService.register(new User(username, password, mail, phone));

        if (user_new == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(user_new);
    }

    @ApiOperation(value = "Login", httpMethod = "POST", response = CommonResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataTypeClass = String.class, required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataTypeClass = String.class, required = true)
    })
    @PostMapping(value = "/login")
    public CommonResult login(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        String token = userAdminService.login(username, password);
        if (token == null) {
            return CommonResult.validateFailed("username or password is wrong");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "用户注销", httpMethod = "POST", response = CommonResult.class)
    @ApiImplicitParam(name = "id", value = "用户id", dataTypeClass = Long.class, required = true)
    @PostMapping("/logout")
    public CommonResult logout(@RequestParam("id") Long id) {
        return null;
    }


    @ApiOperation(value = "获取用户信息", httpMethod = "GET", response = CommonResult.class)
    @ApiImplicitParam(name = "id", value = "用户id", dataTypeClass = Long.class, required = true)
    @GetMapping(value = "/user")
    public CommonResult getUserDetail(@RequestParam("id") Long id) {
        return null;
    }

    @ApiOperation(value = "修改用户信息", httpMethod = "PUT", response = CommonResult.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataTypeClass = Long.class, required = true),
            @ApiImplicitParam(name = "username", value = "用户名", dataTypeClass = String.class, required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataTypeClass = String.class, required = true),
            @ApiImplicitParam(name = "mail", value = "邮箱", dataTypeClass = String.class, required = true),
            @ApiImplicitParam(name = "phone", value = "电话", dataTypeClass = String.class, required = true)
    })
    @PutMapping(value = "/user")
    public CommonResult putUserDetail(
            @RequestParam("id") Long id,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("mail") String mail,
            @RequestParam("phone") String phone
    ) {
        return null;
    }
}
