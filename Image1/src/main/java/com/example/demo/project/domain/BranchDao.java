package com.example.demo.project.domain;

public interface BranchDao {

    void createBranch(String privateToken, String projectName, String branch);
}
