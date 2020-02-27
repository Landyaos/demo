package com.utopia.demo.controller;


import com.utopia.demo.common.CommonResult;
import com.utopia.demo.dto.LoginParam;
import com.utopia.demo.dto.UserParam;
import com.utopia.demo.entity.User;
import com.utopia.demo.service.CaptchaService;
import com.utopia.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api(value = "用户管理控制器")
@RestController
public class UserAdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private CaptchaService captchaService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册", httpMethod = "POST", response = CommonResult.class)
    @GetMapping("/auth")
    public User auth(@RequestBody User user) {
        return user;
    }

    @ApiOperation(value = "用户注册", httpMethod = "POST", response = CommonResult.class)
    @PostMapping(value = "/register")
    public CommonResult register(@RequestBody UserParam userParam) {
        User user_new = userService.register(userParam);
        if (user_new == null) {
            return CommonResult.failed("用户已存在");
        }
        return CommonResult.success(user_new);
    }

    @ApiOperation(value = "用户登录", httpMethod = "POST", response = CommonResult.class)
    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody LoginParam loginParam) {
//        if (!captchaService.verifyCaptcha(username, captcha)) {
//            return CommonResult.failed("验证码错误");
//        }
        String token = userService.login(loginParam.getUsername(), loginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("username or password is wrong");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        tokenMap.put(tokenHeader,tokenHead+token);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "用户注销", httpMethod = "POST", response = CommonResult.class)
    @PostMapping("/logout")
    public CommonResult logout() {
        // jwt 为无状态, 不能主动登出, 前端主动删除token
        return CommonResult.success("登出成功,请删除token!");
    }

    @ApiOperation(value = "获取验证码", httpMethod = "GET", response = CommonResult.class)
    @GetMapping("/captcha")
    public CommonResult getCaptcha(@RequestParam(value = "username") String username) {
        String captcha = captchaService.generateCaptcha(username);
        return CommonResult.success(captcha, "获取验证码成功");
    }

    @ApiOperation(value = "获取单个用户信息", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/user/{id}")
    public CommonResult getUserDetail(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return CommonResult.failed("用户id不存在.");
        }
        return CommonResult.success(user,"获取用户信息成功.");
    }

    @ApiOperation(value = "修改用户信息", httpMethod = "PUT", response = CommonResult.class)
    @PutMapping(value = "/user/{id}")
    public CommonResult putUserDetail(
            @PathVariable(value = "id") long id,
            @RequestBody UserParam userParam) {
        User user = userService.updateUser(userParam);
        if (user == null || id != userParam.getId()) {
            return CommonResult.failed("用户名已存在");
        }
        return CommonResult.success(user, "用户信息更新成功.");
    }
}
