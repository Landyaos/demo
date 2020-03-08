package com.utopia.demo.controller;

import com.utopia.demo.common.CommonResult;
import com.utopia.demo.dto.GenreParam;
import com.utopia.demo.dto.StarringParam;
import com.utopia.demo.entity.Genre;
import com.utopia.demo.entity.Starring;
import com.utopia.demo.service.StarringService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "演员控制器")
@RestController
public class StarringController {

    @Autowired
    private StarringService starringService;

    @ApiOperation(value = "获取所有演员信息", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/starring/_all")
    public CommonResult getStarringAll(
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {
        Page<Starring> starringPage = starringService.getAll(pageNum, pageSize);
        return CommonResult.success(starringPage, "获取演员成功");
    }

    @ApiOperation(value = "搜索演员", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/starring/_search")
    public CommonResult getStarringBySearch(
            @RequestParam(value = "query") Map<String,Object> query,
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {
        Page<Starring> starringPage = starringService.getBySearch(query, pageNum, pageSize);
        return CommonResult.success(starringPage, "获取演员成功");
    }
    @ApiOperation(value = "获取演员byID", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/starring/{id}")
    public CommonResult getStarringById(
            @PathVariable(value = "id") Integer id) {
        Starring starring = starringService.getById(id);
        return CommonResult.success(starring, "获取演员成功");
    }

    @ApiOperation(value = "增加演员", httpMethod = "POST", response = CommonResult.class)
    @PostMapping(value = "/starring")
    public CommonResult addStarring(@RequestBody StarringParam starringParam) {
        Starring starring_new = starringService.add(starringParam);
        if (starring_new == null) {
            return CommonResult.failed("演员已存在");
        }
        return CommonResult.success(starring_new,"添加演员成功");
    }

    @ApiOperation(value = "删除演员", httpMethod = "DELETE", response = CommonResult.class)
    @DeleteMapping(value = "/starring/{id}")
    public CommonResult deleteStarringById(
            @PathVariable(value = "id") long id
    ) {
        if (starringService.deleteById(id)) {
            return CommonResult.success("删除演员成功");
        }
        return CommonResult.failed("删除演员失败");
    }

    @ApiOperation(value = "修改演员信息", httpMethod = "PUT", response = CommonResult.class)
    @PutMapping(value = "/starring/{id}")
    public CommonResult putStarringDetail(
            @PathVariable(value = "id") long id,
            @RequestBody StarringParam starringParam) {
        Starring starring = starringService.update(starringParam);
        if (starring == null || id != starringParam.getId()) {
            return CommonResult.failed("演员已存在，更新失败");
        }
        return CommonResult.success(starring, "演员信息更新成功.");
    }


}
