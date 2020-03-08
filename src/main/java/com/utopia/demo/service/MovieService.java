package com.utopia.demo.service;

import com.utopia.demo.dto.MovieParam;
import com.utopia.demo.entity.Movie;
import com.utopia.demo.nosql.elasticsearch.pojo.EsMovie;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface MovieService {

    Page<Movie> getAll(Integer pageNum, Integer pageSize);

    Page<Movie> getBySearch(Map<String, Object> query, Integer pageNum, Integer pageSize);

    Movie getById(Integer id);

    Movie add(MovieParam movieParam);

    boolean deleteById(long id);

    Movie update(MovieParam movieParam);


    Page<EsMovie> getAllEsMovie(Integer pageNum, Integer pageSize);

    EsMovie getEsMovieById(Long id);

    Page<EsMovie> getPopularRecommend(Integer pageNum, Integer pageSize);

    Page<EsMovie> getPreferRecommend(Integer pageNum, Integer pageSize);

    Page<EsMovie> getColdRecommend(Integer pageNum, Integer pageSize);

    Page<EsMovie> getPreferRecommend(Long id, Integer pageNum, Integer pageSize);

    Page<EsMovie> getColdRecommend(Long id, Integer pageNum, Integer pageSize);

    Page<EsMovie> getSearchEsMovie(Integer pageNum, Integer pageSize, Map query);

}
