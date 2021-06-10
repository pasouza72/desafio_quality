package com.meli.desafioquality.service;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.gateway.model.request.RoomRequest;
import com.meli.desafioquality.gateway.model.response.RoomResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PropertyRoomCalculateService {

    public List<RoomResponse> calculate(HomeRequest request) {
        return request.getRooms()
                .stream()
                .map(this::mountRoomResponse)
                .collect(Collectors.toList());
    }

    private RoomResponse mountRoomResponse(RoomRequest request) {
        var response = new RoomResponse(request);
        response.setSquareMetersTotal(request.getRoomWidth() * request.getRoomLength());

        return response;
    }
}
