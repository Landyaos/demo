package com.utopia.demo.repository;

import com.utopia.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findById(long id);
}
