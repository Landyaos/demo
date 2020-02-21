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
    private EsDemoRepository esDemoRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private EsMovieRepository esMovieRepository;

    @Test
    public void esDemoTest() {
        Set<Genre> genres = new HashSet<>();
        genres.add(new Genre("xxxx"));
        genres.add(new Genre("syyyy"));
        EsDemo esDemo = new EsDemo(1L, "STONE", new Date(), new String[]{"1x23", "xxx"}, genres);
        esDemoRepository.save(esDemo);
    }

    @Test
    public void esMovieTest() {
        Movie movie = movieRepository.findAllById(1);
        EsMovie esMovie = new EsMovie();
        System.out.println(movie);

        BeanUtils.copyProperties(movie, esMovie);
        System.out.println(esMovie);

        esMovieRepository.save(esMovie);

    }
}
