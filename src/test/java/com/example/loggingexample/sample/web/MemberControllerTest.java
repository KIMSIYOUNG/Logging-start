package com.example.loggingexample.sample.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import com.example.loggingexample.sample.MemberRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@Rollback(false)
@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired Logger logger;

    @Autowired MockMvc mockMvc;

    @Autowired ObjectMapper objectMapper;

    @Test
    void name() throws Exception {
        final MemberRequest crew = new MemberRequest("로운");

        mockMvc.perform(post("/members")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsBytes(crew))
        )
            .andExpect(status().isCreated())
            .andDo(print());
    }
}
