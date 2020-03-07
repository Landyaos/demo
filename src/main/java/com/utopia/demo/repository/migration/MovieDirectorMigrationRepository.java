package com.utopia.demo.repository.migration;

import com.utopia.demo.entity.view.MovieDirectorMigration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieDirectorMigrationRepository extends JpaRepository<MovieDirectorMigration, Long> {
    @Query("select mdm from MovieDirectorMigration mdm where mdm.movie_id = ?1")
    List<MovieDirectorMigration> findByMovie_id(Long id);

}
