package com.meli.desafioquality.service;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.gateway.model.request.RoomRequest;
import com.meli.desafioquality.gateway.model.response.RoomResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static java.util.Collections.max;
import static java.util.Comparator.comparing;

@AllArgsConstructor
@Service
public class RoomBiggestService {

    public RoomResponse calculate(HomeRequest request) {
        List<RoomRequest> rooms = request.getRooms();

        Comparator<RoomRequest> comparing = comparing(r -> (r.getRoomLength() * r.getRoomWidth())); //TODO Fazer um serviço para lhe dar com essa conta
        RoomRequest greatestRoom =  max(rooms, comparing);

        return new RoomResponse(greatestRoom);
    }
}
