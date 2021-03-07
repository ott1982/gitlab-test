package com.example.demo.service.impl;

import com.example.demo.entity.Build;
import com.example.demo.repository.BuildDao;
import com.example.demo.service.BuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildServiceImpl extends CommonServiceImpl
        implements BuildService {

    private final BuildDao buildDao;

    @Autowired
    public BuildServiceImpl(BuildDao buildDao) {
        this.buildDao = buildDao;
    }

    @Override
    public Build createBuild(Build build) {
        return buildDao.create(build);
    }
}
