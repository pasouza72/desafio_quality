package com.meli.desafioquality.service;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.gateway.model.response.RoomResponse;
import com.meli.desafioquality.util.PropertyJsonUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoomBiggestServiceTest {

    private final RoomBiggestService service = new RoomBiggestService();

    @Test
    void shouldReturnTheBiggestRoom(){
        HomeRequest request = PropertyJsonUtil.getHomeRequestFromFile();

        RoomResponse calculate = service.calculate(request);

        assertEquals("Sala2", calculate.getRoomName());
    }

}