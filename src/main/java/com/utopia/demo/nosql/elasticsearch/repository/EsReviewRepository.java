package com.utopia.demo.nosql.elasticsearch.repository;

import com.utopia.demo.nosql.elasticsearch.pojo.EsComment;
import com.utopia.demo.nosql.elasticsearch.pojo.EsReview;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsReviewRepository extends ElasticsearchRepository<EsReview, Long> {

}
