package com.utopia.demo.controller;

import com.utopia.demo.common.CommonResult;
import com.utopia.demo.service.ReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api(value = "影评控制器")
@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @ApiOperation(value = "获取指定id电影影评", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/review/{id}")
    public CommonResult<Map<String,Object>> getReview(
            @PathVariable(value = "id") Long id,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        Map<String, Object> map =reviewService.getAllByMovieIdJson(id, pageNum, pageSize);
        if ((int) map.get("status") == 200) {
            return CommonResult.success(map, "获取影评成功");
        } else {
            return CommonResult.failed((String) map.get("errMsg"));
        }    }


}
