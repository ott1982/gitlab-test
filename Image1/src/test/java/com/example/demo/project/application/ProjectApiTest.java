package com.example.demo.project.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ProjectApiTest {
    ProjectApi sut = new ProjectApi((privateKey, name) -> {
        //stub!
    }, (privateToken, projectName, branch) -> {
        //stub!
    }, (privateToken, name, tag) -> {
        //stub!
    });
    MockMvc mockMvc = null;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(sut).build();
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