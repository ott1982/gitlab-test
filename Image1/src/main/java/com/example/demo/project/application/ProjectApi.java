package com.example.demo.project.application;

import com.example.demo.project.domain.BranchDao;
import com.example.demo.project.domain.CreateNewProjectUseCase;
import com.example.demo.project.domain.ProjectDao;
import com.example.demo.project.domain.TagDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectApi {
    private static final Logger logger = LoggerFactory
            .getLogger(ProjectApi.class);
    private final CreateNewProjectUseCase createNewProjectUseCase;

    @Autowired
    public ProjectApi(ProjectDao projectDao, BranchDao branchDao
            , TagDao tagDao) {
        this.createNewProjectUseCase = new CreateNewProjectUseCase(
                projectDao, branchDao, tagDao);
    }

    @PostMapping
    public ResponseEntity<String> createProject(
            @RequestHeader("private-token") String privateToken
            , @RequestParam("project-name") String projectName) {
        if (logger.isDebugEnabled()) {
            logger.debug("createProject:: privateToken: {}; projectName: {}"
                    , privateToken, projectName);
        }
        return new ResponseEntity<>("ok", HttpStatus.CREATED);
    }
}
