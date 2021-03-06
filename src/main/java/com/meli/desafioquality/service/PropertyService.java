package com.meli.desafioquality.service;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.gateway.model.response.PropertyResponse;
import com.meli.desafioquality.util.property.SquareMeterUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PropertyService {

    public PropertyResponse calculate(HomeRequest request) {

        double squareMetersTotal = SquareMeterUtil.calculate(request);

        return PropertyResponse.builder().squareMetersTotal(squareMetersTotal).build();
    }
}
