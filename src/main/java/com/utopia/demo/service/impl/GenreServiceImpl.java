package com.utopia.demo.service.impl;

import com.utopia.demo.dto.GenreParam;
import com.utopia.demo.entity.Genre;
import com.utopia.demo.repository.GenreRepository;
import com.utopia.demo.service.GenreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Page<Genre> getAllGenre(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return genreRepository.findAll(pageable);
    }

    @Override
    public Page<Genre> getGenreByName(String name, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public boolean deleteGenreById(long id) {
        return false;
    }

    @Override
    public Genre getGenreById(Integer id) {
        return genreRepository.findById(id);
    }

    @Override
    public Genre add(GenreParam genreParam) {
        Genre genre_new = new Genre();
        BeanUtils.copyProperties(genreParam, genre_new);
        genreRepository.save(genre_new);
        return genre_new;
    }

    @Override
    public Genre updateGenre(GenreParam genreParam) {
        return null;
    }
}
