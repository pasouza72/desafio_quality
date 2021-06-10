package com.meli.desafioquality.gateway.model.response;

import com.meli.desafioquality.gateway.model.request.RoomRequest;

public class RoomResponse extends RoomRequest {

    public RoomResponse(RoomRequest request) {
        super.setRoomName(request.getRoomName());
        super.setRoomWidth(request.getRoomWidth());
        super.setRoomLength(request.getRoomLength());

    }
}
