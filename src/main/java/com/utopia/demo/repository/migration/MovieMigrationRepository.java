package com.utopia.demo.repository.migration;

import com.utopia.demo.entity.view.MovieMigration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieMigrationRepository extends JpaRepository<MovieMigration, Long> {

}
