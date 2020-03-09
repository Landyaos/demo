package com.utopia.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.utopia.demo.common.INDEX;
import com.utopia.demo.nosql.elasticsearch.pojo.EsComment;
import com.utopia.demo.service.CommentService;
import com.utopia.demo.service.ElasticsearchService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private ElasticsearchService elasticsearchService;
    @Override
    public Map<String, Object> getAllByMovieIdJson(Long movieId, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);

        return elasticsearchService.findCommentReviewByMovieId(INDEX.COMMENT.getIndex(), movieId,pageable, EsComment.class);
    }
}
