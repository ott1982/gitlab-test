package com.example.demo.contoller;

import com.example.demo.controller.ControllerAdvice;
import com.example.demo.controller.ProjectApi;
import com.example.demo.service.impl.CreateNewProjectServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProjectApiTest {
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ProjectApi(
                new CreateNewProjectServiceImpl((privateKey, name) -> {
                    //stub!
                }, (privateToken, projectName, branch) -> {
                    //stub!
                }, (privateToken, name, tag) -> {
                    //stub!
                }))).setControllerAdvice(new ControllerAdvice()).build();
    }

    @Test
    @DisplayName("checks point-to-point GitLab project creation")
    public void createProjectTest() throws Exception {
        mockMvc.perform(post("/project")
                .param("project-name", "oriol")
                .header("private-token", "aaaaaaaaa"))
                .andExpect(status().isCreated());
    }
}