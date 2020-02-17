package com.utopia.demo.nosql.elasticsearch.repository;

import com.utopia.demo.nosql.elasticsearch.pojo.EsDemo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsDemoRepository extends ElasticsearchRepository<EsDemo, Long> {

}
