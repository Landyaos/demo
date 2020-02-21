package com.utopia.demo;

import com.utopia.demo.entity.Genre;
import com.utopia.demo.entity.Movie;
import com.utopia.demo.nosql.elasticsearch.pojo.EsDemo;
import com.utopia.demo.nosql.elasticsearch.pojo.EsMovie;
import com.utopia.demo.nosql.elasticsearch.repository.EsDemoRepository;
import com.utopia.demo.nosql.elasticsearch.repository.EsMovieRepository;
import com.utopia.demo.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RestController
public class ElasticsearchTest {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private EsMovieRepository esMovieRepository;

    @Test
    public void esMovieTest() {

        Movie movie1 = movieRepository.findById(1);
        Movie movie2 = movieRepository.findById(2);
        Movie movie3 = movieRepository.findById(3);

        EsMovie esMovie = new EsMovie();
        BeanUtils.copyProperties(movie1, esMovie);
        esMovieRepository.save(esMovie);
        BeanUtils.copyProperties(movie2, esMovie);
        esMovieRepository.save(esMovie);
        BeanUtils.copyProperties(movie3, esMovie);
        esMovieRepository.save(esMovie);

    }
}
