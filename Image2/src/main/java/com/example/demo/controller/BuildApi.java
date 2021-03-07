package com.example.demo.controller;

import com.example.demo.dto.BuildDto;
import com.example.demo.entity.Build;
import com.example.demo.service.BuildService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/build")
public class BuildApi extends CommonController {
    private static Logger logger = LoggerFactory.getLogger(BuildApi.class);
    private final BuildService buildService;

    @Autowired
    public BuildApi(BuildService buildService) {
        this.buildService = buildService;
    }

    @PostMapping
    public ResponseEntity<BuildDto> postBuild(
            @RequestBody @Valid BuildDto buildDto) {
        return new ResponseEntity<>(new BuildDto(buildService
                .createBuild(new Build(buildDto))), HttpStatus.CREATED);
    }
}
