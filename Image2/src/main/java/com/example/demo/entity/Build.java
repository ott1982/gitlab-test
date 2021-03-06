package com.example.demo.entity;

import com.example.demo.dto.BuildDto;

public class Build {
    private final Number buildId;
    private final String name;
    private final String pathRepo;
    private final String version;

    public Build(Number buildId, String name
            , String pathRepo, String version) {
        this.buildId = buildId;
        this.name = name;
        this.pathRepo = pathRepo;
        this.version = version;
    }

    public Build(BuildDto buildDto) {
        this.buildId = Integer.valueOf(buildDto.getBuildId());
        this.name = buildDto.getName();
        this.pathRepo = buildDto.getPathRepo();
        this.version = buildDto.getVersion();
    }

    public Number getBuildId() {
        return buildId;
    }

    public String getName() {
        return name;
    }

    public String getPathRepo() {
        return pathRepo;
    }

    public String getVersion() {
        return version;
    }
}
