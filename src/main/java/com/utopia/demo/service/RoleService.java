package com.utopia.demo.service;

import com.utopia.demo.dto.RoleParam;
import com.utopia.demo.entity.Role;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RoleService {

    Role addRole(RoleParam roleParam);

    Role updateRole(RoleParam roleParam);

    Boolean deleteRoleById(Long id);

    Role getRoleByName(String name);

    Role getRoleById(Long id);

    Page<Role> getAllRoleByPage(int pageNum, int pageSize);

    Boolean deleteRolePermissionById(Long role_id, Long permission_id);

    Role putRolePermission(Long id, List<Long> permissionList);


}
