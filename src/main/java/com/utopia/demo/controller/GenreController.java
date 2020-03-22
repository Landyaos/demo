package com.utopia.demo.controller;

import com.utopia.demo.common.CommonResult;
import com.utopia.demo.dto.GenreParam;
import com.utopia.demo.entity.Genre;
import com.utopia.demo.service.GenreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Api(value = "类型控制器")
@RestController
public class GenreController {

    @Autowired
    private GenreService genreService;

    @ApiOperation(value = "获取所有类型信息", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/genre/_all")
    public CommonResult getGenreAll(
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {
        Page<Genre> userPage = genreService.getAllGenre(pageNum, pageSize);
        return CommonResult.success(userPage, "获取类型成功");
    }

    @ApiOperation(value = "搜索类型", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/genre/_search")
    public CommonResult getGenreBySearch(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {
        Page<Genre> userPage = genreService.getGenreByName(name, pageNum, pageSize);
        return CommonResult.success(userPage, "获取类型成功");
    }

    @ApiOperation(value = "获取类型byID", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/genre/{id}")
    public CommonResult getGenreById(
            @PathVariable(value = "id") Integer id) {
        Genre genre = genreService.getGenreById(id);
        return CommonResult.success(genre, "获取类型成功");
    }

    @ApiOperation(value = "获取类型byID", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/genre/_name/{name}")
    public CommonResult getGenreByName(
            @PathVariable(value = "name") String name) {
        Genre genre = genreService.getGenreByName(name);
        if (genre != null) {
            return CommonResult.success(genre, "获取类型成功");
        } else {
            return CommonResult.failed("获取类型失败");
        }
    }

    @ApiOperation(value = "增加类型", httpMethod = "POST", response = CommonResult.class)
    @PostMapping(value = "/genre")
    public CommonResult addGenre(@RequestBody GenreParam genreParam) {
        Genre genre_new = genreService.addGenre(genreParam);
        if (genre_new == null) {
            return CommonResult.failed("类型已存在");
        }
        return CommonResult.success(genre_new, "添加类型成功");
    }

    @ApiOperation(value = "删除类型", httpMethod = "DELETE", response = CommonResult.class)
    @DeleteMapping(value = "/genre/{id}")
    public CommonResult deleteGenreById(
            @PathVariable(value = "id") long id
    ) {
        if (genreService.deleteGenreById(id)) {
            return CommonResult.success("删除类型成功");
        }
        return CommonResult.failed("删除类型失败");
    }

    @ApiOperation(value = "修改类型", httpMethod = "PUT", response = CommonResult.class)
    @PutMapping(value = "/genre/{id}")
    public CommonResult putUserDetail(
            @PathVariable(value = "id") long id,
            @RequestBody GenreParam genreParam) {
        Genre genre = genreService.updateGenre(genreParam);
        if (genre == null || id != genreParam.getId()) {
            return CommonResult.failed("类型已存在，更新失败");
        }
        return CommonResult.success(genre, "类型信息更新成功.");
    }

}
