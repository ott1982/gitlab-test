package com.example.demo.repository;

public interface BranchDao {

    void createBranch(String privateToken, String projectName, String branch);
}
