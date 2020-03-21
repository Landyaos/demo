package com.utopia.demo.service;

import com.utopia.demo.dto.PermissionParam;
import com.utopia.demo.entity.Permission;
import org.springframework.data.domain.Page;

public interface PermissionService {


    Permission addPermission(PermissionParam permissionParam);

    Permission getPermissionById(Long id);

    Permission getPermissionByName(String name);

    Permission updatePermission(PermissionParam permissionParam);

    Boolean deletePermission(Long id);

    Page<Permission> getAllPermissionByPage(int pageNum, int pageSize);


}
