package com.utopia.demo.controller;

import com.utopia.demo.common.CommonResult;
import com.utopia.demo.dto.MovieParam;
import com.utopia.demo.entity.Movie;
import com.utopia.demo.service.MovieService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @ApiOperation(value = "获取所有电影信息", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/movie/_all")
    public CommonResult getStarringAll(
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {
        Page<Movie> moviePage = movieService.getAll(pageNum, pageSize);
        return CommonResult.success(moviePage, "获取电影成功");
    }

    @ApiOperation(value = "搜索电影", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/movie/_search")
    public CommonResult getStarringBySearch(
            @RequestParam(value = "query") Map<String,Object> query,
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {
        Page<Movie> moviePage = movieService.getBySearch(query, pageNum, pageSize);
        return CommonResult.success(moviePage, "获取电影成功");
    }
    @ApiOperation(value = "获取电影byID", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/movie/{id}")
    public CommonResult getStarringById(
            @PathVariable(value = "id") Integer id) {
        Movie movie = movieService.getById(id);
        return CommonResult.success(movie, "获取电影成功");
    }

    @ApiOperation(value = "增加电影", httpMethod = "POST", response = CommonResult.class)
    @PostMapping(value = "/movie")
    public CommonResult addStarring(@RequestBody MovieParam movieParam) {
        Movie movie = movieService.add(movieParam);
        if (movie == null) {
            return CommonResult.failed("电影已存在");
        }
        return CommonResult.success(movie,"添加电影成功");
    }

    @ApiOperation(value = "删除电影", httpMethod = "DELETE", response = CommonResult.class)
    @DeleteMapping(value = "/movie/{id}")
    public CommonResult deleteStarringById(
            @PathVariable(value = "id") long id
    ) {
        if (movieService.deleteById(id)) {
            return CommonResult.success("删除电影成功");
        }
        return CommonResult.failed("删除电影失败");
    }

    @ApiOperation(value = "修改电影信息", httpMethod = "PUT", response = CommonResult.class)
    @PutMapping(value = "/movie/{id}")
    public CommonResult putStarringDetail(
            @PathVariable(value = "id") long id,
            @RequestBody MovieParam movieParam) {
        System.out.println(movieParam);
        return CommonResult.success(movieParam, "电影信息更新成功.");
    }

}
