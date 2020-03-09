package com.utopia.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface ElasticsearchService {

   <T> Map<String, Object> findAll(String index, Pageable pageable, Class<T> tClass);

   <T> Map<String, Object> findById(String index, Long id, Pageable pageable, Class<T> tClass);

   <T> Map<String, Object> findCommentReviewByMovieId(String index, Long movieId, Pageable pageable, Class<T> tClass);

   <T> Map<String, Object> findByQuery(String index, Map query, Pageable pageable, Class<T> tClass);



}
