package com.utopia.demo.service;

import com.utopia.demo.dto.DirectorScreenwriterParam;
import com.utopia.demo.entity.DirectorScreenwriter;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface DirectorScreenwriterService {
    Page<DirectorScreenwriter> getAll(Integer pageNum, Integer pageSize);

    Page<DirectorScreenwriter> getBySearch(Map<String, Object> query, Integer pageNum, Integer pageSize);

    DirectorScreenwriter getById(Integer id);

    DirectorScreenwriter add(DirectorScreenwriterParam directorScreenwriterParam);

    DirectorScreenwriter update(DirectorScreenwriterParam directorScreenwriterParam);

    boolean deleteById(long id);
}
