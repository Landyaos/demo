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

    @Test
    public void viewTest() {
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
}