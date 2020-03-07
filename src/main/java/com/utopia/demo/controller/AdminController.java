package com.utopia.demo.controller;

import com.utopia.demo.common.CommonResult;
import com.utopia.demo.dto.GenreParam;
import com.utopia.demo.dto.UserParam;
import com.utopia.demo.entity.*;
import com.utopia.demo.entity.view.*;
import com.utopia.demo.repository.*;
import com.utopia.demo.repository.migration.*;
import com.utopia.demo.service.GenreService;
import com.utopia.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private CommentMigrationRepository commentMigrationRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ReviewMigrationRepository reviewMigrationRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserMigrationRepository userMigrationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DirectorScreenwriterMigrationRepository directorScreenwriterMigrationRepository;
    @Autowired
    private DirectorScreenwriterRepository directorScreenwriterRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private GenreMigrationRepository genreMigrationRepository;
    @Autowired
    private MovieMigrationRepository movieMigrationRepository;
    @Autowired
    private MovieRepository movieRepository;

    @ApiOperation(value = "获取所有用户信息", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/user/_all")
    public CommonResult getUserAll(
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {

        Page<User> userPage = userService.getAllUser(pageNum, pageSize);
        return CommonResult.success(userPage, "获取用户成功");
    }

    @ApiOperation(value = "删除用户", httpMethod = "DELETE", response = CommonResult.class)
    @DeleteMapping(value = "/user/{id}")
    public CommonResult deleteUserById(
            @PathVariable(value = "id") long id
    ) {
        if (userService.deleteUser(id)) {
            return CommonResult.success("删除用户成功");
        }
        return CommonResult.failed("删除用户失败");
    }

    @ApiOperation(value = "数据导入", httpMethod = "POST", response = CommonResult.class)
    @PostMapping(value = "/admin/migration")
    public CommonResult migration() {
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
        return CommonResult.success("数据迁移成功");
    }
}
