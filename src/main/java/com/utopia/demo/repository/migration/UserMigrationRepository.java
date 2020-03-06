package com.utopia.demo.repository.migration;

import com.utopia.demo.entity.view.UserMigration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMigrationRepository extends JpaRepository<UserMigration, String> {

}
