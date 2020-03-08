package com.utopia.demo.nosql.elasticsearch.repository;

import com.utopia.demo.nosql.elasticsearch.pojo.EsComment;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EsCommentRepository extends ElasticsearchRepository<EsComment, Long> {
    @Query(" { \"match_all\": {} }")
    List<EsComment> getAll();
}
