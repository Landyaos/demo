package com.utopia.demo.repository.migration;

import com.utopia.demo.entity.view.MovieStarringMigration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieStarringMigrationRepository extends JpaRepository<MovieStarringMigration, Long> {
    @Query("select msm from MovieStarringMigration msm where msm.movie_id = ?1")
    List<MovieStarringMigration> findByMovie_id(Long id);
}
