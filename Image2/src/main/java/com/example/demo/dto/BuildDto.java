package com.example.demo.dto;

import com.example.demo.entity.Build;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class BuildDto extends CommonDto
        implements Serializable {

    @Pattern(regexp = "\\d+", message = "number")
    private String buildId;

    @Pattern(regexp = "[a-zA-Z]+", message = "string - only letters")
    private String name;

    @Pattern(regexp = "\\\\?[\\w\\\\]+\\w?", message = "string with slashes (\\)")
    private String pathRepo;

    @Pattern(regexp = "\\d{1}\\.\\d{1}\\.\\d{1}", message = "M.m.f")
    private String version;

    public BuildDto() {
    }

    public BuildDto(String buildId, String name
            , String pathRepo, String version) {
        this.buildId = buildId;
        this.name = name;
        this.pathRepo = pathRepo;
        this.version = version;
    }

    public BuildDto(Build build) {
        this.buildId = String.valueOf(build.getBuildId());
        this.name = build.getName();
        this.pathRepo = build.getPathRepo();
        this.version = build.getVersion();
    }

    public String getBuildId() {
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
