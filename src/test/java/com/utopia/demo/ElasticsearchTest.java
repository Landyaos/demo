package com.utopia.demo;

import com.utopia.demo.entity.Genre;
import com.utopia.demo.nosql.elasticsearch.pojo.EsDemo;
import com.utopia.demo.nosql.elasticsearch.repository.EsDemoRepository;
import org.elasticsearch.gateway.GatewayException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RestController
public class ElasticsearchTest {

    @Autowired
    private EsDemoRepository esDemoRepository;

    @Test
    public void esMovieStore() {

    }


}
