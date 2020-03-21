package com.utopia.demo.service.impl;

import com.utopia.demo.dto.PermissionParam;
import com.utopia.demo.entity.Permission;
import com.utopia.demo.repository.PermissionRepository;
import com.utopia.demo.service.PermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Permission addPermission(PermissionParam permissionParam) {
        if (permissionRepository.findByName(permissionParam.getName()) != null) {
            return null;
        } else {
            Permission permission = new Permission();
            BeanUtils.copyProperties(permissionParam, permission);
            permissionRepository.save(permission);
            return permission;
        }
    }


    @Override
    public Permission getPermissionById(Long id) {
        return permissionRepository.findById(id).orElse(null);
    }

    @Override
    public Permission getPermissionByName(String name) {
        return permissionRepository.findByName(name);
    }

    @Override
    public Page<Permission> getAllPermissionByPage(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return permissionRepository.findAll(pageable);
    }

    @Override
    public Permission updatePermission(PermissionParam permissionParam) {
        Permission permission = permissionRepository.findById(permissionParam.getId()).orElse(null);
        if (permission == null) {
            return null;
        } else {
            BeanUtils.copyProperties(permissionParam, permission);
            permissionRepository.save(permission);
            return permission;
        }
    }

    @Override
    public Boolean deletePermission(Long id) {
        permissionRepository.delete(new Permission(id));
        return true;
    }




}
