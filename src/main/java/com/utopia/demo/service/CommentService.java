package com.utopia.demo.service;

import java.util.Map;

public interface CommentService {

    Map<String, Object> getAllByMovieIdJson(Long movieId, Integer pageNum, Integer pageSize);

}
