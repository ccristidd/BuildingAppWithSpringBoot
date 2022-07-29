package com.buildingappwithspringboot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@WebMvcTest loads just the web part of the context
@SpringBootTest //loads the whole application
@AutoConfigureMockMvc
class HelloControllerTest {

    private MockMvc mockMvc;

    @Autowired
    public HelloControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    //test the HelloController controller
    @Test
    public void hello() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/home")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("This text is returned by the HelloController! ")));
    }




}