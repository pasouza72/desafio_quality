package com.meli.desafioquality.gateway.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meli.desafioquality.gateway.model.request.RoomRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@Getter
@Setter
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomResponse extends RoomRequest {

    private Double squareMetersTotal;

    public RoomResponse(RoomRequest request) {
        super.setRoomName(request.getRoomName());
        super.setRoomWidth(request.getRoomWidth());
        super.setRoomLength(request.getRoomLength());
    }

    @Override
    public String toString() {
        return "{" +
                "\"squareMetersTotal\":" + squareMetersTotal + "," +
                "\"room_name\":\"" + super.getRoomName() + "\"," +
                "\"room_width\":" + super.getRoomWidth() +
                ",\"room_length\":" + super.getRoomLength() +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoomResponse response = (RoomResponse) o;
        return Objects.equals(squareMetersTotal, response.squareMetersTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), squareMetersTotal);
    }
}
