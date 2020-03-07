package com.utopia.demo.repository.migration;

import com.utopia.demo.entity.view.MovieGenreMigration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieGenreMigrationRepository extends JpaRepository<MovieGenreMigration, Long> {
    @Query("select mgm from MovieGenreMigration mgm where mgm.movie_id = ?1")
    List<MovieGenreMigration> findByMovie_id(Long id);
}
