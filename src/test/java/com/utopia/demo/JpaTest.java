package com.utopia.demo;

import com.utopia.demo.entity.*;
import com.utopia.demo.entity.view.*;
import com.utopia.demo.repository.*;
import com.utopia.demo.repository.migration.*;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.ReactiveListCommands;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
    @Autowired
    private UserMigrationRepository userMigrationRepository;
    @Autowired
    private MovieMigrationRepository movieMigrationRepository;
    @Autowired
    private MovieGenreMigrationRepository movieGenreMigrationRepository;
    @Autowired
    private MovieDirectorMigrationRepository movieDirectorMigrationRepository;
    @Autowired
    private MovieScreenwriterMigrationRepository movieScreenwriterMigrationRepository;
    @Autowired
    private MovieStarringMigrationRepository movieStarringMigrationRepository;
    @Autowired
    private CommentMigrationRepository commentMigrationRepository;
    @Autowired
    private ReviewMigrationRepository reviewMigrationRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GenreMigrationRepository genreMigrationRepository;
    @Autowired
    private DirectorScreenwriterMigrationRepository directorScreenwriterMigrationRepository;

    @Test
    public void viewTest() {

        List<UserMigration> userMigrationList = userMigrationRepository.findAll();
        for (UserMigration userMigration : userMigrationList) {
            userRepository.save(
                    new User(
                            userMigration.getUsername(),
                            "$2a$10$6shH6IHW9NHEfTckxTyW2eIh9Wot9f0bFvaKbwiEwB/tjVGGdk372",
                            "13653399918",
                            "1453793807@qq.com",
                            userMigration.getIcon()
                    )
            );

        }

        List<GenreMigration> genreMigrationList = genreMigrationRepository.findAll();
        for (GenreMigration genreMigration : genreMigrationList) {
            genreRepository.save(
                    new Genre(
                            genreMigration.getName(),
                            genreMigration.getForeign_name(),
                            genreMigration.getDescription()
                    )
            );
        }

        List<DirectorScreenwriterMigration> directorScreenwriterMigrationList = directorScreenwriterMigrationRepository.findAll();
        for (DirectorScreenwriterMigration directorScreenwriterMigration : directorScreenwriterMigrationList) {
            directorScreenwriterRepository.save(
                    new DirectorScreenwriter(
                            directorScreenwriterMigration.getName(),
                            directorScreenwriterMigration.getForeign_name(),
                            directorScreenwriterMigration.getCover_url(),
                            directorScreenwriterMigration.getDirector(),
                            directorScreenwriterMigration.getScreenwriter(),
                            directorScreenwriterMigration.getDouban_link(),
                            directorScreenwriterMigration.getImdb_link()
                    )
            );
        }

        List<MovieMigration> movieMigrationList = movieMigrationRepository.findAll();
        for (MovieMigration movieMigration : movieMigrationList) {
            movieRepository.save(
                    new Movie(
                            movieMigration.getName(),
                            movieMigration.getForeign_name(),
                            movieMigration.getLength(),
                            movieMigration.getLanguage(),
                            movieMigration.getArea(),
                            movieMigration.getRelease_date(),
                            10000f,
                            movieMigration.getCover_url(),
                            movieMigration.getRate(),
                            movieMigration.getVotes(),
                            movieMigration.getRate_weight(),
                            movieMigration.getImdb_link(),
                            movieMigration.getDouban_link(),
                            null,
                            movieMigration.getProfile()
                    )
            );
        }

        List<Movie> movieList = movieRepository.findAll();
        for (Movie movie : movieList) {
            System.out.println(movie.getId());
            Set<Genre> genreSet = new HashSet<>();
            Set<DirectorScreenwriter> screenwriterSet = new HashSet<>();
            Set<DirectorScreenwriter> directorSet = new HashSet<>();
            Set<Starring> starringSet = new HashSet<>();
            for (MovieGenreMigration movieGenreMigration : movieGenreMigrationRepository.findByMovie_id(movie.getId())) {
                System.out.println(movieGenreMigration);
                genreSet.add(new Genre(movieGenreMigration.getGenre_id()));
            }
            for (MovieStarringMigration movieStarringMigration : movieStarringMigrationRepository.findByMovie_id(movie.getId())) {
                starringSet.add(new Starring(movieStarringMigration.getStarring_id()));
            }
            for (MovieDirectorMigration movieDirectorMigration : movieDirectorMigrationRepository.findByMovie_id(movie.getId())) {
                directorSet.add(new DirectorScreenwriter(movieDirectorMigration.getDirector_id()));
            }
            for (MovieScreenwriterMigration movieScreenwriterMigration : movieScreenwriterMigrationRepository.findByMovie_id(movie.getId())) {
                screenwriterSet.add(new DirectorScreenwriter(movieScreenwriterMigration.getScreenwriter_id()));
            }

            movie.setGenreSet(genreSet);
            movie.setScreenwriterSet(screenwriterSet);
            movie.setDirectorSet(directorSet);
            movie.setStarringSet(starringSet);
            movieRepository.save(movie);
        }

        List<CommentMigration> commentMigrationList = commentMigrationRepository.findAll();
        for (CommentMigration commentMigration : commentMigrationList) {
            commentRepository.save(
                    new Comment(
                            new User(commentMigration.getUser()),
                            new Movie(commentMigration.getMovie()),
                            commentMigration.getRate(),
                            commentMigration.getDate(),
                            commentMigration.getVotes(),
                            commentMigration.getContent()
                    ));
        }

        List<ReviewMigration> reviewMigrationList = reviewMigrationRepository.findAll();
        for (ReviewMigration reviewMigration : reviewMigrationList) {
            reviewRepository.save(
                    new Review(
                            new User(reviewMigration.getUser()),
                            new Movie(reviewMigration.getMovie()),
                            reviewMigration.getTitle(),
                            reviewMigration.getRate(),
                            reviewMigration.getDate(),
                            reviewMigration.getVotes(),
                            reviewMigration.getContent()
                    )
            );
        }

    }

    @Test
    public void movieTest() {

        List<Movie> movieList = movieRepository.findAll();
        for (Movie movie : movieList) {
            Set<DirectorScreenwriter> directorSet = new HashSet<>();

            for (MovieDirectorMigration movieDirectorMigration : movieDirectorMigrationRepository.findByMovie_id(movie.getId())) {

                directorSet.add(new DirectorScreenwriter(movieDirectorMigration.getDirector_id()));
            }
            movie.setDirectorSet(directorSet);
            movieRepository.save(movie);
        }


    }
}