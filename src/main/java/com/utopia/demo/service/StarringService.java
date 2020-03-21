package com.utopia.demo.service;

import com.utopia.demo.dto.StarringParam;
import com.utopia.demo.entity.Genre;
import com.utopia.demo.entity.Starring;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface StarringService {
    Page<Starring> getAll(Integer pageNum, Integer pageSize);

    Page<Starring> getBySearch(Map<String, Object> query, Integer pageNum, Integer pageSize);

    Starring getById(Integer id);

    Starring getOneByName(String name);

    Starring add(StarringParam starringParam);

    boolean deleteById(long id);

    Starring update(StarringParam starringParam);
}
