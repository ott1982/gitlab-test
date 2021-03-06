package com.example.demo.entity;

import java.util.List;

public class Project extends CommonEntity {
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