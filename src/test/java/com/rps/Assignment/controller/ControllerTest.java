package com.rps.Assignment.controller;

import com.rps.Assignment.AssignmentApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
@SpringJUnitWebConfig
@ContextConfiguration(classes = AssignmentApplication.class)
@WebMvcTest
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void AssignmentControllerTest() throws Exception{
        List<String> possibleResults = Arrays.asList("Player wins", "Computer wins", "It is a tie");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/play")
                        .param("move","FAKE MOVE"))
                .andExpect(MockMvcResultMatchers.content().string("Player move is invalid"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        String result = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/play")
                        .param("move","ROCK"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        assertThat(possibleResults.contains(result)).isTrue();

    }
}
