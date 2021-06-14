package com.meli.desafioquality.service;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.gateway.model.response.RoomResponse;
import com.meli.desafioquality.util.PropertyJsonUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PropertyRoomCalculateServiceTest {

    private final PropertyRoomCalculateService service = new PropertyRoomCalculateService();

    @Test
    void shouldReturnRoomWithEachSquareMeterCalculated(){
        HomeRequest request = PropertyJsonUtil.getHomeRequestFromFile();

        List<RoomResponse> response = service.calculate(request);

        assertEquals(100, response.get(0).getSquareMetersTotal());
        assertEquals(400, response.get(1).getSquareMetersTotal());
    }
}