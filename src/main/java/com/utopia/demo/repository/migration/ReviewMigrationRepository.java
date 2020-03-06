package com.utopia.demo.repository.migration;

import com.utopia.demo.entity.view.ReviewMigration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewMigrationRepository extends JpaRepository<ReviewMigration, Long> {

}
