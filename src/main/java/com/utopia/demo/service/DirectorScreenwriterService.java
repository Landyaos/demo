package com.utopia.demo.service;

import com.utopia.demo.dto.DirectorScreenwriterParam;
import com.utopia.demo.entity.DirectorScreenwriter;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface DirectorScreenwriterService {
    Page<DirectorScreenwriter> getAllDirectorScreenwriter(Integer pageNum, Integer pageSize);

    Page<DirectorScreenwriter> getBySearch(Map<String, Object> query, Integer pageNum, Integer pageSize);

    DirectorScreenwriter getOneById(Integer id);

    DirectorScreenwriter getOneByName(String name);

    DirectorScreenwriter addDirectorScreenwriter(DirectorScreenwriterParam directorScreenwriterParam);

    DirectorScreenwriter updateDirectorScreenwriter(DirectorScreenwriterParam directorScreenwriterParam);

    boolean deleteOneById(long id);
}
