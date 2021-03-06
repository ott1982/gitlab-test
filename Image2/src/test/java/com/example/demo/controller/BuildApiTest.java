package com.example.demo.controller;

import com.example.demo.dto.BuildDto;
import com.example.demo.service.impl.BuildServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BuildApiTest {
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new BuildApi(
                new BuildServiceImpl(build -> {
                    // stub!
                    return build;
                }))).setControllerAdvice(new ControllerAdvice()).build();
    }

    @Test
    @DisplayName("checks point-to-point build execution")
    public void should_build() throws Exception {
        mockMvc.perform(post("/build")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(
                        new BuildDto("1", "aaaa", "\\aaa\\aaaaa", "1.0.0")
                ))).andExpect(status().isCreated());
    }

    @Test
    @DisplayName("should_fail_by_buildId")
    public void should_fail_by_buildId() throws Exception {
        mockMvc.perform(post("/build")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(
                        new BuildDto("", "aaaa", "\\aaa\\aaaaa", "1.0.0")
                ))).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("should_fail_by_name")
    public void should_fail_by_name() throws Exception {
        mockMvc.perform(post("/build")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(
                        new BuildDto("1", "aaa222a", "\\aaa\\aaaaa", "1.0.0")
                ))).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("should_fail_by_pathRepo")
    public void should_fail_by_pathRepo() throws Exception {
        mockMvc.perform(post("/build")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(
                        new BuildDto("1", "aaaa", "$$$\\aaa\\aaaaa", "1.0.0")
                ))).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("should_fail_by_tag")
    public void should_fail_by_tag() throws Exception {
        mockMvc.perform(post("/build")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(
                        new BuildDto("1", "aaaa", "\\aaa\\aaaaa", "1.0")
                ))).andExpect(status().isBadRequest());
    }

}