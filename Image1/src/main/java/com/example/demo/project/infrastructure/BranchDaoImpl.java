package com.example.demo.project.infrastructure;

import com.example.demo.project.domain.BranchDao;
import org.springframework.stereotype.Repository;

@Repository
public class BranchDaoImpl implements BranchDao {

    @Override
    public void createBranch(String privateToken, String projectName, String branch) {

    }
}
