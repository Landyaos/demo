package com.utopia.demo.nosql.elasticsearch.repository;

import com.utopia.demo.nosql.elasticsearch.pojo.EsMovie;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Map;

public interface EsMovieRepository extends ElasticsearchRepository<EsMovie, Long> {

}
