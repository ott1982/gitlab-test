package com.example.demo.project.domain;

public class CreateNewProjectUseCase {
    private final ProjectDao projectDao;
    private final BranchDao branchDao;
    private final TagDao tagDao;

    public CreateNewProjectUseCase(ProjectDao projectDao
            , BranchDao branchDao, TagDao tagDao) {
        this.projectDao = projectDao;
        this.branchDao = branchDao;
        this.tagDao = tagDao;
    }

    public void createNewProject(String privateKey, String name) {
        projectDao.createProject(privateKey, name);
        branchDao.createBranch(privateKey, name, "master");
        branchDao.createBranch(privateKey, name, "develop");
        tagDao.createTag(privateKey, name, "0.0.1");
    }
}
