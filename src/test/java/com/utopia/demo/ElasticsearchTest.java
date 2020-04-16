package com.utopia.demo;

import com.alibaba.fastjson.JSON;
import com.utopia.demo.entity.Comment;
import com.utopia.demo.entity.Movie;
import com.utopia.demo.entity.Review;
import com.utopia.demo.nosql.elasticsearch.dto.EsMovieParam;
import com.utopia.demo.nosql.elasticsearch.dto.EsUserParam;
import com.utopia.demo.nosql.elasticsearch.pojo.EsComment;
import com.utopia.demo.nosql.elasticsearch.pojo.EsMovie;
import com.utopia.demo.nosql.elasticsearch.pojo.EsReview;
import com.utopia.demo.nosql.elasticsearch.repository.EsCommentRepository;
import com.utopia.demo.nosql.elasticsearch.repository.EsDemoRepository;
import com.utopia.demo.nosql.elasticsearch.repository.EsMovieRepository;
import com.utopia.demo.nosql.elasticsearch.repository.EsReviewRepository;
import com.utopia.demo.repository.CommentRepository;
import com.utopia.demo.repository.MovieRepository;
import com.utopia.demo.repository.ReviewRepository;
import com.utopia.demo.service.MovieService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.OAuthBuilder;

import java.sql.ClientInfoStatus;
import java.util.*;

@SpringBootTest
@RestController
public class ElasticsearchTest {

    //@Autowired
    //private MovieRepository movieRepository;
    //@Autowired
    //private EsMovieRepository esMovieRepository;
    //@Autowired
    //private CommentRepository commentRepository;
    //@Autowired
    //private EsCommentRepository esCommentRepository;
    //@Autowired
    //private EsReviewRepository esReviewRepository;
    //@Autowired
    //private ReviewRepository reviewRepository;
    //@Autowired
    //private EsDemoRepository esDemoRepository;
    //@Autowired
    //private MovieService movieService;
    //
    //@Autowired
    //private RestHighLevelClient restHighLevelClient;
    //
    //@Test
    //public void esCommentMigration() {
    //    List<Comment> commentList = commentRepository.findAll();
    //    for (Comment comment : commentList) {
    //        EsComment esComment = new EsComment();
    //        BeanUtils.copyProperties(comment, esComment);
    //        EsUserParam esUserParam = new EsUserParam();
    //        BeanUtils.copyProperties(comment.getUser(), esUserParam);
    //        EsMovieParam esMovieParam = new EsMovieParam();
    //        BeanUtils.copyProperties(comment.getMovie(), esMovieParam);
    //        esComment.setUser(esUserParam);
    //        esComment.setMovie(esMovieParam);
    //        esCommentRepository.save(esComment);
    //    }
    //}
    //
    //@Test
    //public void esReviewMigration() {
    //    List<Review> reviewList = reviewRepository.findAll();
    //    for (Review review : reviewList) {
    //        EsReview esReview = new EsReview();
    //        BeanUtils.copyProperties(review, esReview);
    //        EsUserParam esUserParam = new EsUserParam();
    //        BeanUtils.copyProperties(review.getUser(), esUserParam);
    //        EsMovieParam esMovieParam = new EsMovieParam();
    //        BeanUtils.copyProperties(review.getMovie(), esMovieParam);
    //        esReview.setUser(esUserParam);
    //        esReview.setMovie(esMovieParam);
    //        esReviewRepository.save(esReview);
    //    }
    //}
    //
    //@Test
    //public void esMovieMigration() {
    //    List<Movie> movieList = movieRepository.findAll();
    //    for (Movie movie : movieList) {
    //        EsMovie esMovie = new EsMovie();
    //        BeanUtils.copyProperties(movie, esMovie);
    //        esMovieRepository.save(esMovie);
    //    }
    //}
    //
    //@Test
    //public void getEsMovie() {
    //    Pageable pageable = PageRequest.of(0, 10);
    //
    //}
    //
    //@Test
    //public void getDemo() {
    //    try {
    //        Pageable pageable = PageRequest.of(0, 20);
    //
    //        Map<String, Object> map = listPage(pageable, EsMovie.class);
    //        List<EsMovie> esMovieList = (List)map.get("resultList");
    //        esMovieList.forEach(System.out::println);
    //
    //    } catch (Exception e) {
    //        System.out.println(e.getMessage());
    //    }
    //
    //}
    //
    //public <T> Map<String, Object> listPage(Pageable pageable, Class<T> tClass) throws Exception {
    //    //创建检索请求
    //    SearchRequest searchRequest = new SearchRequest("movie");
    //    //创建搜索构建者
    //    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    //    sourceBuilder.query(QueryBuilders.matchAllQuery());
    //    if (pageable != null) {
    //        sourceBuilder.from(pageable.getPageNumber() * pageable.getPageSize()); // 需要注意这里是从多少条开始
    //        sourceBuilder.size(pageable.getPageSize()); //共返回多少条数据
    //    }
    //    searchRequest.source(sourceBuilder);
    //    SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
    //    //处理结果
    //
    //    RestStatus restStatus = searchResponse.status();
    //    if (restStatus != RestStatus.OK) {
    //        System.out.println("搜索错误");
    //    }
    //    List<T> resultList = new ArrayList<>();
    //    SearchHits hits = searchResponse.getHits();
    //    hits.forEach(item -> resultList.add(JSON.parseObject(item.getSourceAsString(), tClass)));
    //    Map<String, Object> map = new HashMap<>();
    //    map.put("resultList", resultList);
    //
    //
    //    return map;
    //    //return new PageImpl<>(list, pageable, hits.getTotalHits().value);
    //}

}
