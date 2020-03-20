package com.utopia.demo.controller;

import com.utopia.demo.common.CommonResult;
import com.utopia.demo.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api(value = "评论控制器")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ApiOperation(value = "获取指定id电影评论", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/comment/{id}")
    public CommonResult<Map<String, Object>> getComment(
            @PathVariable(value = "id") Long id,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        Map<String, Object> map = commentService.getAllByMovieIdJson(id, pageNum, pageSize);
        if ((int) map.get("status") == 200) {
            return CommonResult.success(map, "获取电影评论成功");
        } else {
            return CommonResult.failed((String) map.get("errMsg"));
        }
    }

}
