package com.example.demo.project.domain;

import java.util.List;

public class Project {
    private final String name;
    private final String owner;
    private final List<String> tags;
    private final List<String> branches;

    public Project(String name, String owner
            , List<String> tags, List<String> branches) {
        this.name = name;
        this.owner = owner;
        this.tags = tags;
        this.branches = branches;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<String> getBranches() {
        return branches;
    }
}