package com.meli.desafioquality.gateway.controller;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.util.PropertyJsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PropertyPriceCalculateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final static String URL = "/props/calculation/price";

    @Test
    void shouldReturnOkWhenPayloadIsOk() throws Exception {
        String request = PropertyJsonUtil.getHomeRequestAsStringFromFile();

        String expected = "{\"value\":2500.0}";

        String contentAsString = this.mockMvc.perform(
                                                post(URL)
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
    void shouldReturnExceptionWhenNameIsEmpty() throws Exception {
        HomeRequest homeRequestFromFile = PropertyJsonUtil.getHomeRequestFromFile();
        homeRequestFromFile.setPropName("");

        String request = homeRequestFromFile.toString();

        this.mockMvc.perform(
                post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnExceptionWhenNameIsNull() throws Exception {
        HomeRequest homeRequestFromFile = PropertyJsonUtil.getHomeRequestFromFile();
        homeRequestFromFile.setPropName(null);

        String request = homeRequestFromFile.toString();

        this.mockMvc.perform(
                post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnExceptionWhenRoomWidthIsZero() throws Exception {
        HomeRequest homeRequestFromFile = PropertyJsonUtil.getHomeRequestFromFile();
        homeRequestFromFile.getRooms().get(0).setRoomWidth(0.0);

        String request = homeRequestFromFile.toString();

        this.mockMvc.perform(
                post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnExceptionWhenRoomLengthIsZero() throws Exception {
        HomeRequest homeRequestFromFile = PropertyJsonUtil.getHomeRequestFromFile();
        homeRequestFromFile.getRooms().get(0).setRoomLength(0.0);

        String request = homeRequestFromFile.toString();

        this.mockMvc.perform(
                post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}