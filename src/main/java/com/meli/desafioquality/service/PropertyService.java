package com.meli.desafioquality.service;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.gateway.model.response.PropertyResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PropertyService {

    public PropertyResponse calculate(HomeRequest request) {

        double squareMetersTotal = request.getRooms()
                                            .stream()
                                            .mapToDouble(r -> (r.getRoomLength() * r.getRoomWidth()))
                                            .sum();

        return new PropertyResponse(squareMetersTotal);
    }
}
