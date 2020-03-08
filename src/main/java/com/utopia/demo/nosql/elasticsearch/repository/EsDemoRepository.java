package com.utopia.demo.nosql.elasticsearch.repository;

import com.utopia.demo.nosql.elasticsearch.pojo.EsDemo;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EsDemoRepository extends ElasticsearchRepository<EsDemo, Long> {
    @Query(" { \"match_all\": {} }")
    List<EsDemo> get();
}
