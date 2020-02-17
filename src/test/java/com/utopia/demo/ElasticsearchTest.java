package com.utopia.demo;

import com.utopia.demo.nosql.elasticsearch.pojo.EsDemo;
import com.utopia.demo.nosql.elasticsearch.repository.EsDemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RestController;

@SpringBootTest
@RestController
public class ElasticsearchTest {

//    @Autowired
//    private EsMovieRepository esMovieRepository;
    @Autowired
    private EsDemoRepository esDemoRepository;

    @Test
    public void esMovieStore() {
//        EsMovie esMovie = new EsMovie(1L, "冰雪奇缘", "Frozen", "美国", "English", 106, "http://www.frozen.com", null, 10.0, 13000000, "https://forzen.com", "http://frozen.com", "123456");
//        esMovieRepository.save(esMovie);
        EsDemo esDemo = new EsDemo(1L, "demo", "2018-05-06");
        esDemoRepository.save(esDemo);

    }



}
