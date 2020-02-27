package com.utopia.demo.service;

import com.utopia.demo.dto.GenreParam;
import com.utopia.demo.entity.Genre;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

public interface GenreService {


    Page<Genre> getAllGenre(Integer pageNum, Integer pageSize);


    Page<Genre> getGenreByName(String name, Integer pageNum, Integer pageSize);

    boolean deleteGenreById(long id);

    Genre getGenreById(Integer id);

    Genre add(GenreParam genreParam);

    Genre updateGenre(GenreParam genreParam);
}
