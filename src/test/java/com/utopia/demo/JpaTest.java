package com.utopia.demo;

import com.utopia.demo.entity.DirectorScreenwriter;
import com.utopia.demo.entity.Genre;
import com.utopia.demo.entity.Movie;
import com.utopia.demo.entity.Starring;
import com.utopia.demo.repository.DirectorScreenwriterRepository;
import com.utopia.demo.repository.GenreRepository;
import com.utopia.demo.repository.MovieRepository;
import com.utopia.demo.repository.StarringRepository;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.DataInput;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class JpaTest {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private StarringRepository starringRepository;
    @Autowired
    private DirectorScreenwriterRepository directorScreenwriterRepository;

    @Test
    public void generateTestDate() {

        Set<Genre> genreSet = new HashSet<>();
        Set<DirectorScreenwriter> directorSet = new HashSet<>();
        Set<DirectorScreenwriter> screenwriterSet = new HashSet<>();
        Set<Starring> starringSet = new HashSet<>();

        for (int i = 1; i <= 11; i++) {
            Genre genre = new Genre("类型" + i);
            genreRepository.save(genre);
        }

        for (int i = 1; i <= 11; i++) {
            Starring starring = new Starring("演员" + i);
            starringRepository.save(starring);
        }

        for (int i = 1; i <= 11; i++) {
            DirectorScreenwriter directorScreenwriter = new DirectorScreenwriter("导编" + i);
            directorScreenwriterRepository.save(directorScreenwriter);
        }
    }

    @Test
    public void generateMovieTest() {

        for (long i = 1; i <= 10; ) {
            Set<Genre> genreSet = new HashSet<>();
            Set<DirectorScreenwriter> directorSet = new HashSet<>();
            Set<DirectorScreenwriter> screenwriterSet = new HashSet<>();
            Set<Starring> starringSet = new HashSet<>();
            genreSet.add(genreRepository.getOne(i));
            genreSet.add(genreRepository.getOne(i + 1));
            starringSet.add(starringRepository.getOne(i));
            starringSet.add(starringRepository.getOne(i + 1));
            directorSet.add(directorScreenwriterRepository.getOne(i));
            directorSet.add(directorScreenwriterRepository.getOne(i + 1));
            screenwriterSet.add(directorScreenwriterRepository.getOne(i));
            screenwriterSet.add(directorScreenwriterRepository.getOne(i + 1));

            Movie movie = new Movie("电影" + i, 124, new Date(), 10.0f, directorSet, screenwriterSet, starringSet, genreSet);
            movieRepository.save(movie);

            i += 2;
        }

    }

    @Test
    public void jpaTest1() {
        Movie movie = movieRepository.findAllById(1L);
        System.out.println(movie);
        System.out.println(movie.getGenreSet());
    }
}
