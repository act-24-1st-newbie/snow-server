package com.sds.snow.todo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sds.snow.todo.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TaskControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    TaskRepository repository;

    @Test
    public void testCreate() throws Exception {
        // Setting Data
        var data = Map.of("contents", "This is test task");

        // assert
        mockMvc.perform(post("/api/v1/task")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(data))
        ).andExpect(status().isOk());
    }

    @Test
    public void testFind() throws Exception {
        mockMvc.perform(get("/api/v1/task")
        ).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testUpdate() throws Exception {
        var data = Map.of("contents", "This is test task");

        // create
        MvcResult result = mockMvc.perform(post("/api/v1/task")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(data))
        ).andExpect(status().isOk())
                .andReturn();

        // get ID
        long id = Long.parseLong(result.getResponse().getContentAsString());

        // patch
        mockMvc.perform(patch("/api/v1/task/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(Map.of("isDone", "true")))
        ).andExpect(status().isOk());

        // get and check
        mockMvc.perform(get("/api/v1/task")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].isDone").value(true));
    }

    @Test
    public void testDelete() throws Exception {
        var data = Map.of("contents", "This is test task");

        // create
        MvcResult result = mockMvc.perform(post("/api/v1/task")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(data))
                ).andExpect(status().isOk())
                .andReturn();

        long id = Long.parseLong(result.getResponse().getContentAsString());

        // delete
        mockMvc.perform(delete("/api/v1/task/" + id))
                .andExpect((status()).isOk());
    }
}
