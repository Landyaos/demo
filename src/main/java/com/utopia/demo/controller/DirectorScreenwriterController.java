package com.utopia.demo.controller;

import com.utopia.demo.common.CommonResult;
import com.utopia.demo.dto.DirectorScreenwriterParam;
import com.utopia.demo.entity.DirectorScreenwriter;
import com.utopia.demo.service.DirectorScreenwriterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "导演编剧控制器")
@RestController
public class DirectorScreenwriterController {
    @Autowired
    private DirectorScreenwriterService directorScreenwriterService;

    @ApiOperation(value = "获取所有的导演编剧信息", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/directorScreenwriter/_all")
    public CommonResult getDirectorScreenwriterAll(
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {
        Page<DirectorScreenwriter> directorScreenwriterPage = directorScreenwriterService.getAllDirectorScreenwriter(pageNum, pageSize);
        return CommonResult.success(directorScreenwriterPage, "获取导演编剧成功");
    }

    @ApiOperation(value = "搜索导演编剧", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/directorScreenwriter/_search")
    public CommonResult getDirectorScreenwriterBySearch(
            @RequestParam(value = "query") Map<String,Object> query,
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {
        Page<DirectorScreenwriter> directorScreenwriterPage = directorScreenwriterService.getBySearch(query, pageNum, pageSize);
        return CommonResult.success(directorScreenwriterPage, "获取导演编剧成功");
    }

    @ApiOperation(value = "获取导演编剧byID", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/directorScreenwriter/{id}")
    public CommonResult getDirectorAndScreenwriterById(
            @PathVariable(value = "id") Integer id) {
        DirectorScreenwriter directorScreenwriter = directorScreenwriterService.getOneById(id);
        return CommonResult.success(directorScreenwriter, "获取导演编剧成功");
    }

    @ApiOperation(value = "获取导演编剧byName", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/directorScreenwriter/_name/{name}")
    public CommonResult getDirectorAndScreenwriterByName(
            @PathVariable(value = "name") String name) {
        DirectorScreenwriter directorScreenwriter = directorScreenwriterService.getOneByName(name);
        if (directorScreenwriter != null) {
            return CommonResult.success(directorScreenwriter, "获取导演编剧成功");
        } else {
            return CommonResult.failed("获取导演编剧失败");
        }
    }

    @ApiOperation(value = "增加导演编剧", httpMethod = "POST", response = CommonResult.class)
    @PostMapping(value = "/directorScreenwriter")
    public CommonResult addDirectorAndScreenwriter(@RequestBody DirectorScreenwriterParam directorScreenwriterParam) {
        DirectorScreenwriter directorScreenwriter = directorScreenwriterService.addDirectorScreenwriter(directorScreenwriterParam);
        if (directorScreenwriterParam == null) {
            return CommonResult.failed("导演编剧已存在");
        }
        return CommonResult.success(directorScreenwriter,"添加导演编剧成功");
    }

    @ApiOperation(value = "删除演员", httpMethod = "DELETE", response = CommonResult.class)
    @DeleteMapping(value = "/directorScreenwriter/{id}")
    public CommonResult deleteDirectorScreenwriterById(
            @PathVariable(value = "id") long id
    ) {
        if (directorScreenwriterService.deleteOneById(id)) {
            return CommonResult.success("删除导演编剧成功");
        }
        return CommonResult.failed("删除导演编剧失败");
    }

    @ApiOperation(value = "修改导演编剧信息", httpMethod = "PUT", response = CommonResult.class)
    @PutMapping(value = "/directorScreenwriter/{id}")
    public CommonResult putDirectorScreenwriterDetail(
            @PathVariable(value = "id") long id,
            @RequestBody DirectorScreenwriterParam directorScreenwriterParam) {
        DirectorScreenwriter directorScreenwriter = directorScreenwriterService.updateDirectorScreenwriter(directorScreenwriterParam);
        if (directorScreenwriter == null || id != directorScreenwriterParam.getId()) {
            return CommonResult.failed("导演编剧已存在，更新失败");
        }
        return CommonResult.success(directorScreenwriter, "导演编剧信息更新成功.");
    }





}
