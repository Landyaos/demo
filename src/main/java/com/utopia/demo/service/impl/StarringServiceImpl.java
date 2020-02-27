package com.utopia.demo.service.impl;

import com.utopia.demo.dto.StarringParam;
import com.utopia.demo.entity.Starring;
import com.utopia.demo.repository.StarringRepository;
import com.utopia.demo.service.StarringService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class StarringServiceImpl implements StarringService {

    @Autowired
    private StarringRepository starringRepository;

    @Override
    public Page<Starring> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return starringRepository.findAll(pageable);
    }

    @Override
    public Page<Starring> getBySearch(Map<String, Object> query, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public Starring getById(Integer id) {

        return starringRepository.findById(id);
    }

    @Override
    public Starring add(StarringParam starringParam) {
        Starring starring = new Starring();
        BeanUtils.copyProperties(starringParam, starring);
        starringRepository.save(starring);
        return starring;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public Starring update(StarringParam starringParam) {
        Starring starring = starringRepository.findById(starringParam.getId()).orElse(null);
        if (starring == null) {
            return null;
        }
        BeanUtils.copyProperties(starringParam, starring);
        starringRepository.save(starring);
        return starring;
    }
}
