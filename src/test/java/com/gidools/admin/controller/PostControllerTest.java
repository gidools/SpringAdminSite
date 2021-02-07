package com.gidools.admin.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void create() throws Exception {
        mvc.perform(post("/api/postMethod")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"tester@example.com\"," +
                        "\"account\":\"Tester\",\"page\":20}"))
                .andExpect(status().isOk());
    }

}