package com.utopia.demo.repository;

import com.utopia.demo.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Permission findById(long id);

    Permission findByName(String name);


}
