package com.meli.desafioquality.util.property;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.gateway.model.request.RoomRequest;

public class SquareMeterUtil {
    private SquareMeterUtil() { throw new IllegalStateException("Utility class"); }

    public static Double calculate(HomeRequest request){
        return request.getRooms()
                        .stream()
                        .mapToDouble( RoomRequest::getSquareMeterCalculated)
                        .sum();
    }
}
