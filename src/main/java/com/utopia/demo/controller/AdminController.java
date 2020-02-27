package com.utopia.demo.controller;

import com.utopia.demo.common.CommonResult;
import com.utopia.demo.dto.GenreParam;
import com.utopia.demo.dto.UserParam;
import com.utopia.demo.entity.Genre;
import com.utopia.demo.entity.User;
import com.utopia.demo.repository.GenreRepository;
import com.utopia.demo.service.GenreService;
import com.utopia.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取所有用户信息", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/user/_all")
    public CommonResult getUserAll(
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {

        Page<User> userPage = userService.getAllUser(pageNum, pageSize);
        return CommonResult.success(userPage, "获取用户成功");
    }

    @ApiOperation(value = "删除用户", httpMethod = "DELETE", response = CommonResult.class)
    @DeleteMapping(value = "/user/{id}")
    public CommonResult deleteUserById(
            @PathVariable(value = "id") long id
    ) {
        if (userService.deleteUser(id)) {
            return CommonResult.success("删除用户成功");
        }
        return CommonResult.failed("删除用户失败");
    }

}
