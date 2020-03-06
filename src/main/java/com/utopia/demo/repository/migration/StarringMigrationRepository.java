package com.utopia.demo.repository.migration;

import com.utopia.demo.entity.view.StarringMigration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarringMigrationRepository extends JpaRepository<StarringMigration, Long> {

}
