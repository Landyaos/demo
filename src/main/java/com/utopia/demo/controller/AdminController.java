package com.utopia.demo.controller;

import com.utopia.demo.common.CommonResult;
import com.utopia.demo.dto.GenreParam;
import com.utopia.demo.dto.UserParam;
import com.utopia.demo.entity.*;
import com.utopia.demo.entity.view.*;
import com.utopia.demo.nosql.elasticsearch.dto.EsMovieParam;
import com.utopia.demo.nosql.elasticsearch.dto.EsUserParam;
import com.utopia.demo.nosql.elasticsearch.pojo.EsComment;
import com.utopia.demo.nosql.elasticsearch.pojo.EsMovie;
import com.utopia.demo.nosql.elasticsearch.pojo.EsReview;
import com.utopia.demo.nosql.elasticsearch.repository.EsCommentRepository;
import com.utopia.demo.nosql.elasticsearch.repository.EsMovieRepository;
import com.utopia.demo.nosql.elasticsearch.repository.EsReviewRepository;
import com.utopia.demo.repository.*;
import com.utopia.demo.repository.migration.*;
import com.utopia.demo.service.GenreService;
import com.utopia.demo.service.PermissionService;
import com.utopia.demo.service.RoleService;
import com.utopia.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Api(value = "管理端控制器")
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
    @Autowired
    private MovieStarringMigrationRepository movieStarringMigrationRepository;
    @Autowired
    private MovieScreenwriterMigrationRepository movieScreenwriterMigrationRepository;
    @Autowired
    private MovieGenreMigrationRepository movieGenreMigrationRepository;
    @Autowired
    private MovieDirectorMigrationRepository movieDirectorMigrationRepository;
    @Autowired
    private EsCommentRepository esCommentRepository;
    @Autowired
    private EsReviewRepository esReviewRepository;
    @Autowired
    private EsMovieRepository esMovieRepository;

    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private RoleRepository roleRepository;

    @ApiOperation(value = "获取所有用户信息", httpMethod = "GET", response = CommonResult.class)
    @GetMapping(value = "/user/_all")
    public CommonResult getUserAll(
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {

        Page<User> userPage = userService.getAllUser(pageNum, pageSize);
        return CommonResult.success(userPage, "获取用户成功");
    }

    @ApiOperation(value = "更改用户角色", httpMethod = "PUT", response = CommonResult.class)
    @PutMapping(value = "/user/{user_id}/role/{role_id}")
    public CommonResult putUserRole(
            @PathVariable(value = "user_id") Long user_id,
            @PathVariable(value = "role_id") Long role_id
    ) {
        User user = userService.putUserRole(user_id, role_id);
        if (user != null) {
            return CommonResult.success("更新用户角色成功");
        } else {
            return CommonResult.failed("更新用户角色失败");
        }
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
    @PostMapping(value = "/admin/migration/mysql")
    public CommonResult mysqlMigration() {
        try {
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

            return CommonResult.success("数据导入Mysql成功");
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }

    }

    @ApiOperation(value = "Es导入", httpMethod = "POST", response = CommonResult.class)
    @PostMapping(value = "/admin/migration/es")
    public CommonResult esMigration() {
        try {
            List<Movie> movieList = movieRepository.findAll();
            for (Movie movie : movieList) {
                EsMovie esMovie = new EsMovie();
                BeanUtils.copyProperties(movie, esMovie);
                esMovieRepository.save(esMovie);
            }

            List<Comment> commentList = commentRepository.findAll();
            for (Comment comment : commentList) {
                EsComment esComment = new EsComment();
                BeanUtils.copyProperties(comment, esComment);
                EsUserParam esUserParam = new EsUserParam();
                BeanUtils.copyProperties(comment.getUser(), esUserParam);
                EsMovieParam esMovieParam = new EsMovieParam();
                BeanUtils.copyProperties(comment.getMovie(),esMovieParam);
                esComment.setUser(esUserParam);
                esComment.setMovie(esMovieParam);
                esCommentRepository.save(esComment);
            }

            List<Review> reviewList = reviewRepository.findAll();
            for (Review review : reviewList) {
                EsReview esReview = new EsReview();
                BeanUtils.copyProperties(review, esReview);
                EsUserParam esUserParam = new EsUserParam();
                BeanUtils.copyProperties(review.getUser(), esUserParam);
                EsMovieParam esMovieParam = new EsMovieParam();
                BeanUtils.copyProperties(review.getMovie(),esMovieParam);
                esReview.setUser(esUserParam);
                esReview.setMovie(esMovieParam);
                esReviewRepository.save(esReview);
            }

            return CommonResult.success("数据导入Es成功");
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

    @ApiOperation(value = "初始化角色&权限", httpMethod = "POST", response = CommonResult.class)
    @PostMapping(value = "/admin/migration/role/permission")
    public CommonResult roleAndPermissionMigration() {

        try {
            List<Permission> permissionList = new ArrayList<>();
            permissionList.add(new Permission("用户权限", "涉及用户资源相关的", "/movie"));
            permissionList.add(new Permission("电影资源访问权限", "涉及电影资源访问权限", "/movie"));
            permissionList.add(new Permission("演员资源访问权限", "涉及演员资源访问权限", "/starring"));
            permissionList.add(new Permission("导编资源访问权限", "涉及导编资源访问权限", "/directorScreenwriter"));
            permissionList.add(new Permission("类型资源访问权限", "涉及类型资源访问权限", "/genre"));
            permissionList.add(new Permission("管理权限", "涉及管理权限", "/admin"));
            permissionList.add(new Permission("登录权限", "涉及登录权限", "/login"));
            permissionList.add(new Permission("Elasticsearch权限", "涉及Elasticsearch权限", "/es"));
            permissionList.add(new Permission("VIP权限", "涉及VIP权限", "/vip"));
            for (Permission permission : permissionList) {

                permissionRepository.save(permission);
            }

            Set<Permission> permissionSet = new HashSet<>();

            Role role = new Role("普通用户","普通用户");
            permissionSet.add(new Permission(1L));
            permissionSet.add(new Permission(2L));
            permissionSet.add(new Permission(3L));
            permissionSet.add(new Permission(4L));
            permissionSet.add(new Permission(5L));
            role.setPermissionSet(permissionSet);
            roleRepository.save(role);
            permissionSet.clear();

            role = new Role("VIP用户","VIP用户");
            permissionSet.add(new Permission(1L));
            permissionSet.add(new Permission(2L));
            permissionSet.add(new Permission(3L));
            permissionSet.add(new Permission(4L));
            permissionSet.add(new Permission(5L));
            permissionSet.add(new Permission(9L));
            role.setPermissionSet(permissionSet);
            roleRepository.save(role);
            permissionSet.clear();

            role = new Role("管理员","管理");
            permissionSet.add(new Permission(1L));
            permissionSet.add(new Permission(6L));
            permissionSet.add(new Permission(7L));
            role.setPermissionSet(permissionSet);
            roleRepository.save(role);
            permissionSet.clear();

            role = new Role("超级管理员","超级管理");
            permissionSet.add(new Permission(1L));
            permissionSet.add(new Permission(6L));
            permissionSet.add(new Permission(7L));
            permissionSet.add(new Permission(8L));
            role.setPermissionSet(permissionSet);
            roleRepository.save(role);
            permissionSet.clear();


            return CommonResult.success("数据导入Es成功");
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
    }

}
