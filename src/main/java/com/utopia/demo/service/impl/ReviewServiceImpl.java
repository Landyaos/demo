package com.utopia.demo.service.impl;

import com.utopia.demo.common.INDEX;
import com.utopia.demo.nosql.elasticsearch.pojo.EsReview;
import com.utopia.demo.service.ElasticsearchService;
import com.utopia.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ElasticsearchService elasticsearchService;

    @Override
    public Map<String, Object> getAllByMovieIdJson(Long movieId, Integer pageNum, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);

        return elasticsearchService.findCommentReviewByMovieId(INDEX.REVIEW.getIndex(), movieId, pageable, EsReview.class);
    }

}
