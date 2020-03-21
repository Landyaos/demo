package com.utopia.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.utopia.demo.common.CommonResult;
import com.utopia.demo.dto.GenreParam;
import com.utopia.demo.dto.RoleParam;
import com.utopia.demo.entity.Genre;
import com.utopia.demo.entity.Permission;
import com.utopia.demo.entity.Role;
import com.utopia.demo.repository.RoleRepository;
import com.utopia.demo.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.internal.metadata.aggregated.rule.OverridingMethodMustNotAlterParameterConstraints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api(value = "角色控制器")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "获取所有角色信息", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/role/_all")
    public CommonResult getAllRole(
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {
        Page<Role> rolePage = roleService.getAllRoleByPage(pageNum, pageSize);
        return CommonResult.success(rolePage, "获取所有角色成功");
    }

    @ApiOperation(value = "获取角色ByName", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/role/_name/{name}")
    public CommonResult getRoleByName(
            @PathVariable(value = "name") String name
    ) {
        Role role = roleService.getRoleByName(name);
        if (role != null) {
            return CommonResult.success(role, "获取角色成功");
        } else {
            return CommonResult.failed("角色不存在");
        }
    }


    @ApiOperation(value = "获取角色byID", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/role/{id}")
    public CommonResult getRoleById(
            @PathVariable(value = "id") Long id
    ) {
        Role role = roleService.getRoleById(id);
        if (role != null) {
            return CommonResult.success(role, "获取类型成功");
        } else {
            return CommonResult.failed("角色不存在");
        }
    }

    @ApiOperation(value = "增加角色", httpMethod = "POST", response = CommonResult.class)
    @PostMapping(value = "/role")
    public CommonResult addRole(
            @RequestBody RoleParam roleParam
    ) {
        Role role = roleService.addRole(roleParam);
        if (role == null) {
            return CommonResult.failed("角色已存在");
        }
        return CommonResult.success(role, "添加角色成功");
    }

    @ApiOperation(value = "删除角色", httpMethod = "DELETE", response = CommonResult.class)
    @DeleteMapping(value = "/role/{id}")
    public CommonResult deleteRoleById(
            @PathVariable(value = "id") Long id
    ) {
        if (roleService.deleteRoleById(id)) {
            return CommonResult.success("删除角色成功");
        }
        return CommonResult.failed("删除角色失败");
    }

    @ApiOperation(value = "修改类型", httpMethod = "PUT", response = CommonResult.class)
    @PutMapping(value = "/role/{id}")
    public CommonResult putRoleDetail(
            @PathVariable(value = "id") long id,
            @RequestBody RoleParam roleParam) {
        Role role = roleService.updateRole(roleParam);
        if (role == null || id != roleParam.getId()) {
            return CommonResult.failed("角色已存在，更新失败");
        }
        return CommonResult.success(role, "角色信息更新成功.");
    }

    @ApiOperation(value = "删除角色权限", httpMethod = "DELETE", response = CommonResult.class)
    @DeleteMapping(value = "/role/{role_id}/permission/{permission_id}")
    public CommonResult putRoleDetail(
            @PathVariable(value = "role_id") Long role_id,
            @PathVariable(value = "permission_id") Long permission_id
    ) {
        if (roleService.deleteRolePermissionById(role_id, permission_id)) {
            return CommonResult.success("删除权限成功");
        } else {
            return CommonResult.failed("删除权限失败");
        }
    }

    @ApiOperation(value = "更新角色权限列表", httpMethod = "PUT", response = CommonResult.class)
    @PutMapping(value = "/role/{role_id}/permission")
    public CommonResult putRoleDetail(
            @PathVariable(value = "role_id") Long role_id,
            @RequestBody Map<String, List<Long>> map
    ) {

        Role role = roleService.putRolePermission(role_id, map.get("permissionList"));

        if (role != null) {
            return CommonResult.success("更新权限成功");
        } else {
            return CommonResult.failed("更新权限失败");
        }
    }


}
