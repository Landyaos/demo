package com.utopia.demo.repository;

import com.utopia.demo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findById(long id);

}
