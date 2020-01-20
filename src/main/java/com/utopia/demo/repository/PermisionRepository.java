package com.utopia.demo.repository;

import com.utopia.demo.model.Permission;
import com.utopia.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermisionRepository extends JpaRepository<Permission, Long> {

}
