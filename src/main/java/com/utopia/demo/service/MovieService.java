package com.utopia.demo.service;

import com.utopia.demo.dto.MovieParam;
import com.utopia.demo.dto.StarringParam;
import com.utopia.demo.entity.Movie;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface MovieService {
    Page<Movie> getAll(Integer pageNum, Integer pageSize);

    Page<Movie> getBySearch(Map<String, Object> query, Integer pageNum, Integer pageSize);

    Movie getById(Integer id);

    Movie add(MovieParam movieParam);

    boolean deleteById(long id);

    Movie update(MovieParam movieParam);
}
