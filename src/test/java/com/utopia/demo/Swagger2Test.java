package com.utopia.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootTest
@RestController
@Api()
public class Swagger2Test {

    @Test
    @ApiOperation("swagger test")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "username", dataTypeClass = String.class, value = "用户名")})
    @GetMapping("/stagger")
    @ResponseBody
    public void swagger2Test() {
        System.out.println(132);
    }


}
