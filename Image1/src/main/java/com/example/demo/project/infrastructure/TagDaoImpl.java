package com.example.demo.project.infrastructure;

import com.example.demo.project.domain.TagDao;
import org.springframework.stereotype.Repository;

@Repository
public class TagDaoImpl implements TagDao {

    @Override
    public void createTag(String privateToken, String name, String tag) {

    }
}
