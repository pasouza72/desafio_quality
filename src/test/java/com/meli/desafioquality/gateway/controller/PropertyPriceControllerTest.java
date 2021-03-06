package com.meli.desafioquality.gateway.controller;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.util.PropertyJsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PropertyPriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnOkWhenRequestIsValid() throws Exception {
        String request = PropertyJsonUtil.getHomeRequestAsStringFromFile();
        String expected = "{\"squareMetersTotal\":500.0}";

        String contentAsString = this.mockMvc.perform(
                post("/props/calculation/square/meters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals(expected, contentAsString);
    }

    @Test
    void shouldReturnExceptionWhenHasNotRoom() throws Exception {
        HomeRequest homeRequestFromFile = PropertyJsonUtil.getHomeRequestFromFile();
        homeRequestFromFile.setRooms(new ArrayList<>());

        String request = homeRequestFromFile.toString();

        this.mockMvc.perform(
                post("/props/calculation/square/meters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}