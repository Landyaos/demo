package com.utopia.demo.service.impl;

import com.google.gson.internal.$Gson$Preconditions;
import com.utopia.demo.dto.RoleParam;
import com.utopia.demo.entity.Permission;
import com.utopia.demo.entity.Role;
import com.utopia.demo.repository.RoleRepository;
import com.utopia.demo.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role addRole(RoleParam roleParam) {
        if (roleRepository.findByName(roleParam.getName()) != null) {
            Role role = new Role();
            BeanUtils.copyProperties(roleParam, role);
            roleRepository.save(role);
            return role;
        }
        return null;
    }

    @Override
    public Role updateRole(RoleParam roleParam) {
        Role role = roleRepository.findById(roleParam.getId()).orElse(null);
        if (role != null) {
            BeanUtils.copyProperties(roleParam, role);
            roleRepository.save(role);
            return role;
        }
        return null;
    }

    @Override
    public Boolean deleteRoleById(Long id) {
        try {
            roleRepository.delete(new Role(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Role getRoleByName(String name) {
        return null;
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Role> getAllRoleByPage(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return roleRepository.findAll(pageable);
    }

    @Override
    public Boolean deleteRolePermissionById(Long role_id, Long permission_id) {
        try {
            Role role = roleRepository.findById(role_id).orElse(null);
            assert role != null;
            Set<Permission> permissionSet = role.getPermissionSet();
            permissionSet.removeIf(permission -> permission.getId().equals(permission_id));
            role.setPermissionSet(permissionSet);
            roleRepository.save(role);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Role putRolePermission(Long id, List<Long> permissionList) {
        try {
            Role role = roleRepository.findById(id).orElse(null);
            Set<Permission> permissionSet = new HashSet<>();
            for (Long permission_id : permissionList) {
                permissionSet.add(new Permission(permission_id));
            }
            assert role != null;
            role.setPermissionSet(permissionSet);
            roleRepository.save(role);
            return role;
        } catch (Exception e) {
            return null;
        }

    }
}
