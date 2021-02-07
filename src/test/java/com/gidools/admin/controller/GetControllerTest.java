package com.gidools.admin.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GetController.class)
public class GetControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getRequest() throws Exception {
        mvc.perform(get("/api/getMethod"))
                .andExpect(status().isOk());
    }

    @Test
    public void getParameter() throws Exception {
        mvc.perform(get("/api/getParameter?id=Jack&password=testest"))
                .andExpect(status().isOk());
    }

    @Test
    public void getMultiParameter() throws Exception {
        mvc.perform(get("/api/getMultiParameter?account=Jack&email=jack@example.com&page=20"))
                .andExpect(status().isOk());
    }

}