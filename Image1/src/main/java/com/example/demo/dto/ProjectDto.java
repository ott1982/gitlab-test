package com.example.demo.dto;

import com.example.demo.entity.Project;

import java.util.List;

public class ProjectDto extends CommonDto {
    private final String name;
    private final String owner;
    private final List<String> branches;
    private final List<String> tags;

    public ProjectDto(String name, String owner
            , List<String> branches, List<String> tags) {
        this.name = name;
        this.owner = owner;
        this.branches = branches;
        this.tags = tags;
    }

    public ProjectDto(Project project) {
        this.name = project.getName();
        this.owner = project.getOwner();
        this.branches = project.getBranches();
        this.tags = project.getTags();
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public List<String> getBranches() {
        return branches;
    }

    public List<String> getTags() {
        return tags;
    }
}
