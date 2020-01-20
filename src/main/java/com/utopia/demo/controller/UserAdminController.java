package com.utopia.demo.controller;


import com.utopia.demo.common.CommonResult;
import com.utopia.demo.model.User;
import com.utopia.demo.service.UserAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户管理
 * 业务：{
 * 1、login/register
 * 2、
 * }
 */
@Api(tags = "UserAdminController")
@RestController
public class UserAdminController {

    @Autowired
    private UserAdminService userAdminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @GetMapping(value = "/auth")
    @ResponseBody
    public String auth() {
        return "Hello auth";
    }

    @ApiOperation("Register")
    @PostMapping(value = "/register")
    @ResponseBody
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

    @ApiOperation("Login")
    @PostMapping(value = "/login")
    @ResponseBody
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
}
