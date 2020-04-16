package com.utopia.demo.service.impl;

import com.utopia.demo.common.INDEX;
import com.utopia.demo.dto.MovieParam;
import com.utopia.demo.dto.SearchQueryParam;
import com.utopia.demo.entity.Movie;
import com.utopia.demo.nosql.elasticsearch.pojo.EsMovie;
import com.utopia.demo.nosql.elasticsearch.repository.EsMovieRepository;
import com.utopia.demo.repository.MovieRepository;
import com.utopia.demo.service.ElasticsearchService;
import com.utopia.demo.service.MovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private EsMovieRepository esMovieRepository;
    @Autowired
    private ElasticsearchService elasticsearchService;


    @Override
    public Page<Movie> getAllByPageFromSql(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return movieRepository.findAll(pageable);
    }

    @Override
    public Page<Movie> getSearchByPageFromSql(Map<String, Object> query, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public Movie getOneByIdFromSql(Integer id) {
        return movieRepository.findById(id);
    }

    @Override
    public Movie getOneByNameFromSql(String name) {
        return movieRepository.findByName(name);
    }

    @Override
    public Movie putToSql(MovieParam movieParam) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieParam, movie);
        movieRepository.save(movie);
        return movie;
    }

    @Override
    public boolean deleteByIdFromSql(long id) {
        try {
            movieRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Movie updateByIdFromSql(MovieParam movieParam) {
        Movie movie = movieRepository.findById(movieParam.getId()).orElse(null);
        if (movie == null) {
            return null;
        }
        BeanUtils.copyProperties(movieParam, movie);
        movieRepository.save(movie);
        return movie;
    }


    /**
     * 重灾区 repository 弃用
     */
    @Override
    public Page<EsMovie> getAllEsMovie(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return esMovieRepository.findAll(pageable);
    }

    @Override
    public EsMovie getEsMovieById(Long id) {
        return esMovieRepository.findById(id).orElse(null);
    }

    @Override
    public Page<EsMovie> getPopularRecommend(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return esMovieRepository.findAll(pageable);
    }

    @Override
    public Page<EsMovie> getPreferRecommend(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return esMovieRepository.findAll(pageable);
    }

    @Override
    public Page<EsMovie> getColdRecommend(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return esMovieRepository.findAll(pageable);
    }

    @Override
    public Page<EsMovie> getPreferRecommend(Long id, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public Page<EsMovie> getColdRecommend(Long id, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public Page<EsMovie> getSearchEsMovie(Integer pageNum, Integer pageSize, Map query) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return esMovieRepository.findAll(pageable);
    }


    /**
     * 替代方案
     */
    @Override
    public Map<String, Object> getOneByIdFromEs(Long id) {
        return elasticsearchService.findById(INDEX.MOVIE.getIndex(), id, null, EsMovie.class);
    }

    @Override
    public Map<String, Object> getAllByPageFromEs(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return elasticsearchService.findAll(INDEX.MOVIE.getIndex(), pageable, EsMovie.class);
    }

    @Override
    public Map<String, Object> getPopularRecommendByPageFromEs(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return elasticsearchService.findAll(INDEX.MOVIE.getIndex(), pageable, EsMovie.class);
    }

    @Override
    public Map<String, Object> getPreferRecommendByPageFromEs(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return elasticsearchService.findAll(INDEX.MOVIE.getIndex(), pageable, EsMovie.class);
    }

    @Override
    public Map<String, Object> getColdRecommendByPageFromEs(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return elasticsearchService.findAll(INDEX.MOVIE.getIndex(), pageable, EsMovie.class);
    }

    @Override
    public Map<String, Object> getPreferRecommendByPageFromEs(Long userId, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return elasticsearchService.findAll(INDEX.MOVIE.getIndex(), pageable, EsMovie.class);
    }

    @Override
    public Map<String, Object> getColdRecommendByPageFromEs(Long userId, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return elasticsearchService.findAll(INDEX.MOVIE.getIndex(), pageable, EsMovie.class);
    }

    @Override
    public Map<String, Object> getSearchByPageFromEs(Integer pageNum, Integer pageSize, SearchQueryParam searchQueryParam) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return elasticsearchService.findByQuery(INDEX.MOVIE.getIndex(), searchQueryParam, pageable, EsMovie.class);
    }

    @Override
    public Map<String, Object> getRankByPageFromEs(Integer pageNum, Integer pageSize, String sortKernel) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return elasticsearchService.findByRank(INDEX.MOVIE.getIndex(), sortKernel, pageable, EsMovie.class);
    }
}
