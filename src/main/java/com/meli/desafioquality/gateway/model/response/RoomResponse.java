package com.meli.desafioquality.gateway.model.response;

import com.meli.desafioquality.gateway.model.request.RoomRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomResponse extends RoomRequest {

    private Double squareMetersTotal;

    public RoomResponse(RoomRequest request) {
        super.setRoomName(request.getRoomName());
        super.setRoomWidth(request.getRoomWidth());
        super.setRoomLength(request.getRoomLength());
    }
}
