package com.example.webcheckitems.controller;

import com.example.webcheckitems.cheker.StorageText;
import com.example.webcheckitems.dto.TextRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class BracketsRestControllerTest {

    private final String URL = "/api/checkBrackets";

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @Autowired
    BracketsRestControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }


    @Test
    @DisplayName("Checking the correctness of the request")
    void checkText() throws Exception {
        for (Map.Entry<String, Boolean> entry : StorageText.init().entrySet()) {
            mockMvc.perform(
                            post(URL)
                                    .content(objectMapper.writeValueAsBytes(new TextRequest(entry.getKey())))
                                    .contentType(MediaType.APPLICATION_JSON)
                    )
                    .andExpect(
                            MockMvcResultMatchers.jsonPath("$.isCorrect").value(entry.getValue())
                    );
        }

    }

    @Test
    @DisplayName("Request with a confused body")
    void checkTextWithEmptyText() throws Exception {
        String[] texts = {"", "     ", null};
        for (String text : texts) {
            mockMvc.perform(
                            post(URL)
                                    .content(objectMapper.writeValueAsBytes(new TextRequest(text)))
                                    .contentType(MediaType.APPLICATION_JSON)
                    )
                    .andExpect(
                            MockMvcResultMatchers.jsonPath("$.statusCode").value(400)
                    );
        }

    }
}