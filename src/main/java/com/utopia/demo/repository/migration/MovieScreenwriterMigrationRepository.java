package com.utopia.demo.repository.migration;

import com.utopia.demo.entity.view.MovieScreenwriterMigration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieScreenwriterMigrationRepository extends JpaRepository<MovieScreenwriterMigration, Long> {
    @Query("select msm from MovieScreenwriterMigration msm where msm.movie_id = ?1")
    List<MovieScreenwriterMigration> findByMovie_id(Long id);
}
