package com.example.demo.controller;

import com.example.demo.service.CreateNewProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectApi extends CommonController {
    private static final Logger logger = LoggerFactory
            .getLogger(ProjectApi.class);
    private final CreateNewProjectService createNewProjectService;

    @Autowired
    public ProjectApi(CreateNewProjectService createNewProjectService) {
        this.createNewProjectService = createNewProjectService;
    }

    @PostMapping
    public ResponseEntity<String> createProject(
            @RequestHeader("private-token") String privateToken
            , @RequestParam("project-name") String projectName) {
        if (logger.isDebugEnabled()) {
            logger.debug("createProject:: privateToken: {}; projectName: {}"
                    , privateToken, projectName);
        }
        createNewProjectService.createNewProject(privateToken, projectName);
        return new ResponseEntity<>("ok", HttpStatus.CREATED);
    }
}
