package com.meli.desafioquality.gateway.controller;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.gateway.model.request.RoomRequest;
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
class RoomBiggestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final static String URL = "/props/calculation/room/biggest";

    @Test
    void shouldReturnOkWhenRoomIsOK() throws Exception {
        String request = PropertyJsonUtil.getHomeRequestAsStringFromFile();
        RoomRequest room = RoomRequest.builder().roomName("Sala2").roomWidth(20.0).roomLength(20.0).build();

        String expected = room.toString();

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
    void shouldReturnExceptionWhenRoomIsEmpty() throws Exception {
        HomeRequest homeRequestFromFile = PropertyJsonUtil.getHomeRequestFromFile();
        homeRequestFromFile.setRooms(new ArrayList<>());
        String request = homeRequestFromFile.toString();

        makeRequestAndExpectBadRequest(request);

    }

    @Test
    void shouldReturnExceptionWhenRoomIsNull() throws Exception {
        HomeRequest homeRequestFromFile = PropertyJsonUtil.getHomeRequestFromFile();
        homeRequestFromFile.setRooms(null);
        String request = homeRequestFromFile.toString();

        makeRequestAndExpectBadRequest(request);
    }

    @Test
    void shouldReturnExceptionWhenRoomHasWidthEqualsZeroOrLess() throws Exception {
        HomeRequest homeRequestFromFile = PropertyJsonUtil.getHomeRequestFromFile();
        homeRequestFromFile.getRooms().get(0).setRoomWidth(0.0);
        String request = homeRequestFromFile.toString();

        makeRequestAndExpectBadRequest(request);
    }

    @Test
    void shouldReturnExceptionWhenRoomHasWidthMoreThanTwentyFive() throws Exception {
        HomeRequest homeRequestFromFile = PropertyJsonUtil.getHomeRequestFromFile();
        homeRequestFromFile.getRooms().get(0).setRoomWidth(26.0);
        String request = homeRequestFromFile.toString();

        makeRequestAndExpectBadRequest(request);
    }

    @Test
    void shouldReturnExceptionWhenRoomHasLengthEqualsOrLessThanZero() throws Exception {
        HomeRequest homeRequestFromFile = PropertyJsonUtil.getHomeRequestFromFile();
        homeRequestFromFile.getRooms().get(0).setRoomLength(0.0);
        String request = homeRequestFromFile.toString();

        makeRequestAndExpectBadRequest(request);
    }

    @Test
    void shouldReturnExceptionWhenRoomHasLengthMoreThanThirtyThree() throws Exception {
        HomeRequest homeRequestFromFile = PropertyJsonUtil.getHomeRequestFromFile();
        homeRequestFromFile.getRooms().get(0).setRoomLength(34.0);
        String request = homeRequestFromFile.toString();

        makeRequestAndExpectBadRequest(request);
    }

    private void makeRequestAndExpectBadRequest(String request) throws Exception {
        this.mockMvc.perform(
                post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}