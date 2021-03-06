package com.example.demo.service.impl;

import com.example.demo.repository.BranchDao;
import com.example.demo.repository.ProjectDao;
import com.example.demo.repository.TagDao;
import com.example.demo.service.CreateNewProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateNewProjectServiceImpl
        implements CreateNewProjectService {
    private final ProjectDao projectDao;
    private final BranchDao branchDao;
    private final TagDao tagDao;

    @Autowired
    public CreateNewProjectServiceImpl(ProjectDao projectDao
            , BranchDao branchDao, TagDao tagDao) {
        this.projectDao = projectDao;
        this.branchDao = branchDao;
        this.tagDao = tagDao;
    }

    @Override
    public void createNewProject(String privateKey, String name) {
        projectDao.createProject(privateKey, name);
        branchDao.createBranch(privateKey, name, "master");
        branchDao.createBranch(privateKey, name, "develop");
        tagDao.createTag(privateKey, name, "0.0.1");
    }
}
