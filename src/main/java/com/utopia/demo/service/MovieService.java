package com.utopia.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.utopia.demo.dto.MovieParam;
import com.utopia.demo.entity.Movie;
import com.utopia.demo.nosql.elasticsearch.pojo.EsMovie;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface MovieService {

    Page<Movie> getAllByPageFromSql(Integer pageNum, Integer pageSize);

    Page<Movie> getSearchByPageFromSql(Map<String, Object> query, Integer pageNum, Integer pageSize);

    Movie getOneByIdFromSql(Integer id);

    Movie getOneByNameFromSql(String name);

    Movie putToSql(MovieParam movieParam);

    boolean deleteByIdFromSql(long id);

    Movie updateByIdFromSql(MovieParam movieParam);

    // bug 重灾区
    Page<EsMovie> getAllEsMovie(Integer pageNum, Integer pageSize);

    EsMovie getEsMovieById(Long id);

    Page<EsMovie> getPopularRecommend(Integer pageNum, Integer pageSize);

    Page<EsMovie> getPreferRecommend(Integer pageNum, Integer pageSize);

    Page<EsMovie> getColdRecommend(Integer pageNum, Integer pageSize);

    Page<EsMovie> getPreferRecommend(Long id, Integer pageNum, Integer pageSize);

    Page<EsMovie> getColdRecommend(Long id, Integer pageNum, Integer pageSize);

    Page<EsMovie> getSearchEsMovie(Integer pageNum, Integer pageSize, Map query);


    // 替代方案
    Map<String, Object> getOneByIdFromEs(Long id);

    Map<String, Object> getAllByPageFromEs(Integer pageNum, Integer pageSize);

    Map<String, Object> getPopularRecommendByPageFromEs(Integer pageNum, Integer pageSize);

    Map<String, Object> getPreferRecommendByPageFromEs(Integer pageNum, Integer pageSize);

    Map<String, Object> getColdRecommendByPageFromEs(Integer pageNum, Integer pageSize);

    Map<String, Object> getPreferRecommendByPageFromEs(Long userId, Integer pageNum, Integer pageSize);

    Map<String, Object> getColdRecommendByPageFromEs(Long userId, Integer pageNum, Integer pageSize);

    Map<String, Object> getSearchByPageFromEs(Integer pageNum, Integer pageSize, Map query);
}
