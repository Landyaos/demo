package com.utopia.demo.service.impl;

import com.sun.xml.bind.v2.model.core.ID;
import com.utopia.demo.dto.MovieParam;
import com.utopia.demo.entity.Movie;
import com.utopia.demo.repository.MovieRepository;
import com.utopia.demo.service.MovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Page<Movie> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return movieRepository.findAll(pageable);
    }

    @Override
    public Page<Movie> getBySearch(Map<String, Object> query, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public Movie getById(Integer id) {
        return movieRepository.findById(id);
    }

    @Override
    public Movie add(MovieParam movieParam) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieParam, movie);
        movieRepository.save(movie);
        return movie;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public Movie update(MovieParam movieParam) {
        Movie movie = movieRepository.findById(movieParam.getId()).orElse(null);
        if (movie == null) {
            return null;
        }
        BeanUtils.copyProperties(movieParam, movie);
        movieRepository.save(movie);
        return movie;
    }

}
