package com.utopia.demo.repository;

import com.utopia.demo.model.UserRoleRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRelationRepository extends JpaRepository<UserRoleRelation, Long> {

}
