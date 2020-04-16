package com.utopia.demo.service;

import com.utopia.demo.dto.SearchQueryParam;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface ElasticsearchService {

   <T> Map<String, Object> findAll(String index, Pageable pageable, Class<T> tClass);

   <T> Map<String, Object> findById(String index, Long id, Pageable pageable, Class<T> tClass);

   <T> Map<String, Object> findCommentReviewByMovieId(String index, Long movieId, Pageable pageable, Class<T> tClass);

   <T> Map<String, Object> findByQuery(String index, SearchQueryParam searchQueryParam, Pageable pageable, Class<T> tClass);

   <T> Map<String, Object> findByRank(String index, String sortKernel, Pageable pageable, Class<T> tClass);


}
