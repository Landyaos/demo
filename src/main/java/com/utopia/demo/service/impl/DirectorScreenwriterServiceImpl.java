package com.utopia.demo.service.impl;

import com.utopia.demo.dto.DirectorScreenwriterParam;
import com.utopia.demo.entity.DirectorScreenwriter;
import com.utopia.demo.repository.DirectorScreenwriterRepository;
import com.utopia.demo.service.DirectorScreenwriterService;
import org.elasticsearch.gateway.DanglingIndicesState;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DirectorScreenwriterServiceImpl implements DirectorScreenwriterService {

    @Autowired
    private DirectorScreenwriterRepository directorScreenwriterRepository;

    @Override
    public Page<DirectorScreenwriter> getAllDirectorScreenwriter(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return directorScreenwriterRepository.findAll(pageable);
    }

    @Override
    public Page<DirectorScreenwriter> getBySearch(Map<String, Object> query, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public DirectorScreenwriter getOneById(Integer id) {
        return directorScreenwriterRepository.findById(id);
    }

    @Override
    public DirectorScreenwriter getOneByName(String name) {
        return directorScreenwriterRepository.findByName(name);

    }

    @Override
    public DirectorScreenwriter addDirectorScreenwriter(DirectorScreenwriterParam directorScreenwriterParam) {
        if (directorScreenwriterRepository.findById(directorScreenwriterParam.getId()).orElse(null) != null) {
            return null;
        }
        DirectorScreenwriter directorScreenwriter = new DirectorScreenwriter();
        BeanUtils.copyProperties(directorScreenwriterParam, directorScreenwriter);
        directorScreenwriterRepository.save(directorScreenwriter);
        return directorScreenwriter;
    }

    @Override
    public DirectorScreenwriter updateDirectorScreenwriter(DirectorScreenwriterParam directorScreenwriterParam) {
        DirectorScreenwriter directorScreenwriter = directorScreenwriterRepository.findById(directorScreenwriterParam.getId()).orElse(null);
        if (directorScreenwriter == null) {
            return null;
        }
        BeanUtils.copyProperties(directorScreenwriterParam, directorScreenwriter);
        directorScreenwriterRepository.save(directorScreenwriter);
        return directorScreenwriter;
    }

    @Override
    public boolean deleteOneById(long id) {
        return false;
    }
}
