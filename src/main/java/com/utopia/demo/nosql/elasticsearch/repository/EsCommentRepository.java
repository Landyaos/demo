package com.utopia.demo.nosql.elasticsearch.repository;

import com.utopia.demo.nosql.elasticsearch.pojo.EsComment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsCommentRepository extends ElasticsearchRepository<EsComment, Long> {

}
