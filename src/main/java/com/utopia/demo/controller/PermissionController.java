package com.utopia.demo.controller;

import com.utopia.demo.common.CommonResult;
import com.utopia.demo.dto.GenreParam;
import com.utopia.demo.dto.PermissionParam;
import com.utopia.demo.entity.Genre;
import com.utopia.demo.entity.Permission;
import com.utopia.demo.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Api(value = "权限控制器")
@RestController
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @ApiOperation(value = "获取所有权限信息", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/permission/_all")
    public CommonResult getPermissionAll(
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {
        Page<Permission> permissionPage = permissionService.getAllPermissionByPage(pageNum, pageSize);
        return CommonResult.success(permissionPage, "获取所有权限成功");
    }

    @ApiOperation(value = "获取所有权限ById", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/permission/{id}")
    public CommonResult getPermissionById(
            @PathVariable(value = "id") Long id
    ) {
        Permission permission = permissionService.getPermissionById(id);
        if (permission != null) {
            return CommonResult.success(permission, "获取权限成功");
        }else
            return CommonResult.failed("权限不存在");
    }


    @ApiOperation(value = "获取所有权限ById", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/permission/_name/{name}")
    public CommonResult getPermissionByName(
            @PathVariable(value = "name") String name
    ) {
        Permission permission = permissionService.getPermissionByName(name);
        if (permission != null) {
            return CommonResult.success(permission, "获取权限成功");
        }else
            return CommonResult.failed("权限不存在");
    }

    @ApiOperation(value = "增加权限", httpMethod = "POST", response = CommonResult.class)
    @PostMapping(value = "/permission")
    public CommonResult addGenre(@RequestBody PermissionParam permissionParam) {
        Permission permission = permissionService.addPermission(permissionParam);
        if (permission == null) {
            return CommonResult.failed("权限已存在");
        }
        return CommonResult.success(permission,"添加权限成功");
    }

    @ApiOperation(value = "删除权限", httpMethod = "DELETE", response = CommonResult.class)
    @DeleteMapping(value = "/permission/{id}")
    public CommonResult deletePermissionById(
            @PathVariable(value = "id") long id
    ) {
        if (permissionService.deletePermission(id)) {
            return CommonResult.success("删除权限成功");
        }
        return CommonResult.failed("删除权限失败");
    }

    @ApiOperation(value = "修改权限", httpMethod = "PUT", response = CommonResult.class)
    @PutMapping(value = "/permission/{id}")
    public CommonResult putPermissionDetail(
            @PathVariable(value = "id") long id,
            @RequestBody PermissionParam permissionParam) {
        Permission permission = permissionService.updatePermission(permissionParam);
        if (permission == null || id != permissionParam.getId()) {
            return CommonResult.failed("权限已存在，更新失败");
        }
        return CommonResult.success(permission, "权限信息更新成功.");
    }

}
