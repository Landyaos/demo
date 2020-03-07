package com.utopia.demo;

import com.utopia.demo.entity.Comment;
import com.utopia.demo.entity.Movie;
import com.utopia.demo.entity.Review;
import com.utopia.demo.nosql.elasticsearch.dto.EsMovieParam;
import com.utopia.demo.nosql.elasticsearch.dto.EsUserParam;
import com.utopia.demo.nosql.elasticsearch.pojo.EsComment;
import com.utopia.demo.nosql.elasticsearch.pojo.EsMovie;
import com.utopia.demo.nosql.elasticsearch.pojo.EsReview;
import com.utopia.demo.nosql.elasticsearch.repository.EsCommentRepository;
import com.utopia.demo.nosql.elasticsearch.repository.EsMovieRepository;
import com.utopia.demo.nosql.elasticsearch.repository.EsReviewRepository;
import com.utopia.demo.repository.CommentRepository;
import com.utopia.demo.repository.MovieRepository;
import com.utopia.demo.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootTest
@RestController
public class ElasticsearchTest {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private EsMovieRepository esMovieRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private EsCommentRepository esCommentRepository;
    @Autowired
    private EsReviewRepository esReviewRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Test
    public void esCommentMigration() {
        List<Comment> commentList = commentRepository.findAll();
        for (Comment comment : commentList) {
            EsComment esComment = new EsComment();
            BeanUtils.copyProperties(comment, esComment);
            EsUserParam esUserParam = new EsUserParam();
            BeanUtils.copyProperties(comment.getUser(), esUserParam);
            EsMovieParam esMovieParam = new EsMovieParam();
            BeanUtils.copyProperties(comment.getMovie(),esMovieParam);
            esComment.setEsUserParam(esUserParam);
            esComment.setEsMovieParam(esMovieParam);
            esCommentRepository.save(esComment);
        }

    }

    @Test
    public void esReviewMigration() {
        List<Review> reviewList = reviewRepository.findAll();
        for (Review review : reviewList) {
            EsReview esReview = new EsReview();
            BeanUtils.copyProperties(review, esReview);
            EsUserParam esUserParam = new EsUserParam();
            BeanUtils.copyProperties(review.getUser(), esUserParam);
            EsMovieParam esMovieParam = new EsMovieParam();
            BeanUtils.copyProperties(review.getMovie(),esMovieParam);
            esReview.setEsUserParam(esUserParam);
            esReview.setEsMovieParam(esMovieParam);
            esReviewRepository.save(esReview);
        }


    }

    @Test
    public void esMovieMigration() {
        List<Movie> movieList = movieRepository.findAll();
        for (Movie movie : movieList) {
            EsMovie esMovie = new EsMovie();
            BeanUtils.copyProperties(movie, esMovie);
            esMovieRepository.save(esMovie);
        }



    }
}
