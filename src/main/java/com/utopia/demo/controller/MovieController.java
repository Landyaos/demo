package com.utopia.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import com.utopia.demo.common.CommonResult;
import com.utopia.demo.dto.MovieParam;
import com.utopia.demo.entity.Movie;
import com.utopia.demo.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "电影控制器")
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @ApiOperation(value = "获取所有电影信息", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/movie/_all")
    public CommonResult<Page<Movie>> getAllMovie(
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {
        Page<Movie> moviePage = movieService.getAllByPageFromSql(pageNum, pageSize);
        return CommonResult.success(moviePage, "获取电影成功");
    }

    @ApiOperation(value = "搜索电影", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/movie/_search")
    public CommonResult<Page<Movie>> getMovieBySearch(
            @RequestParam(value = "query") Map<String, Object> query,
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {
        Page<Movie> moviePage = movieService.getSearchByPageFromSql(query, pageNum, pageSize);
        return CommonResult.success(moviePage, "获取电影成功");
    }

    @ApiOperation(value = "获取电影byID", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/movie/{id}")
    public CommonResult<Movie> getMovieById(
            @PathVariable(value = "id") Integer id) {
        Movie movie = movieService.getOneByIdFromSql(id);
        return CommonResult.success(movie, "获取电影成功");
    }

    @ApiOperation(value = "获取电影byName", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/movie/_name/{name}")
    public CommonResult<Movie> getMovieByName(
            @PathVariable(value = "name") String name) {
        Movie movie = movieService.getOneByNameFromSql(name);
        if (movie != null) {
            return CommonResult.success(movie, "获取电影成功");
        } else {
            return CommonResult.failed("获取电影失败");
        }
    }

    @ApiOperation(value = "增加电影", httpMethod = "POST", response = CommonResult.class)
    @PostMapping(value = "/movie")
    public CommonResult addMovie(@RequestBody MovieParam movieParam) {
        Movie movie = movieService.putToSql(movieParam);
        if (movie == null) {
            return CommonResult.failed("电影已存在");
        }
        return CommonResult.success(movie, "添加电影成功");
    }

    @ApiOperation(value = "删除电影", httpMethod = "DELETE", response = CommonResult.class)
    @DeleteMapping(value = "/movie/{id}")
    public CommonResult deleteMovieById(
            @PathVariable(value = "id") long id
    ) {
        if (movieService.deleteByIdFromSql(id)) {
            return CommonResult.success("删除电影成功");
        }
        return CommonResult.failed("删除电影失败");
    }

    @ApiOperation(value = "修改电影信息", httpMethod = "PUT", response = CommonResult.class)
    @PutMapping(value = "/movie/{id}")
    public CommonResult putMovieDetail(
            @PathVariable(value = "id") long id,
            @RequestBody MovieParam movieParam) {
        System.out.println(movieParam);
        return CommonResult.success(movieParam, "电影信息更新成功.");
    }


    @ApiOperation(value = "es获取电影信息", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/movie/es/{id}")
    public CommonResult getEsMovieDetail(
            @PathVariable(value = "id") long id
    ) {
        Map<String, Object> map = movieService.getOneByIdFromEs(id);
        //EsMovie esMovie = movieService.getEsMovieById(id);
        if ((int) map.get("status") == 200) {
            return CommonResult.success(map, "获取ES电影成功");
        } else {
            return CommonResult.failed((String) map.get("errMsg"));
        }
    }

    @ApiOperation(value = "es获取热门电影", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/movie/es/popular")
    public CommonResult getEsMoviePopularRecommend(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "16") Integer pageSize
    ) {
        Map<String, Object> map = movieService.getPopularRecommendByPageFromEs(pageNum, pageSize);
        //Page<EsMovie> esMoviePage = movieService.getPopularRecommend(pageNum, pageSize);
        if ((int) map.get("status") == 200) {
            return CommonResult.success(map, "获取ES热门推荐成功");
        } else {
            return CommonResult.failed((String) map.get("errMsg"));
        }
    }

    @ApiOperation(value = "es获取偏好电影", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = {"/movie/es/prefer/{user_id}", "/movie/es/prefer"})
    public CommonResult getEsMoviePreferRecommend(
            @PathVariable(value = "user_id", required = false) Long user_id,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "16") Integer pageSize
    ) {
        Map<String, Object> map;
        //Page<EsMovie> esMoviePage;
        if (user_id == null) {
            map = movieService.getPreferRecommendByPageFromEs(pageNum, pageSize);
            //esMoviePage = movieService.getPreferRecommend(pageNum, pageSize);
        } else {
            map = movieService.getPreferRecommendByPageFromEs(user_id, pageNum, pageSize);
            //esMoviePage = movieService.getPreferRecommend(user_id, pageNum, pageSize);
        }
        if ((int) map.get("status") == 200) {
            return CommonResult.success(map, "获取偏好推荐成功");
        } else {
            return CommonResult.failed((String) map.get("errMsg"));
        }
    }

    @ApiOperation(value = "es获取冷门电影", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = {"/movie/es/cold/{user_id}", "/movie/es/cold"})
    public CommonResult getEsMovieColdRecommend(
            @PathVariable(value = "user_id", required = false) Long user_id,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "16") Integer pageSize
    ) {
        Map<String, Object> map;
        //Page<EsMovie> esMoviePage;
        if (user_id == null) {
            //esMoviePage = movieService.getColdRecommend(pageNum, pageSize);
            map = movieService.getColdRecommendByPageFromEs(pageNum, pageSize);
        } else {
            //esMoviePage = movieService.getColdRecommend(user_id, pageNum, pageSize);
            map = movieService.getColdRecommendByPageFromEs(user_id, pageNum, pageSize);
        }
        if ((int) map.get("status") == 200) {
            return CommonResult.success(map, "获取ES冷门推荐成功");
        } else {
            return CommonResult.failed((String) map.get("errMsg"));
        }
    }


    @ApiOperation(value = "es获取查询电影", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/movie/es/_search")
    public CommonResult getEsMovieSearch(
            @RequestParam(value = "query", required = false) Map<String, String> query,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize
    ) {
        //Page<EsMovie> esMoviePage = movieService.getSearchEsMovie(pageNum, PageSize, query);
        Map<String, Object> map = movieService.getSearchByPageFromEs(pageNum, pageSize, query);
        if ((int) map.get("status") == 200) {
            return CommonResult.success(map, "获取ES搜索成功");
        } else {
            return CommonResult.failed((String) map.get("errMsg"));
        }
    }
}
