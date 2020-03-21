package com.utopia.demo.repository;

import com.utopia.demo.entity.Starring;
import org.elasticsearch.search.aggregations.support.ValuesSourceAggregationBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarringRepository extends JpaRepository<Starring, Long> {

    Starring findById(long id);

    Starring findByName(String name);

}
