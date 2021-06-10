package com.meli.desafioquality.service;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.gateway.model.response.PropertyResponse;
import com.meli.desafioquality.util.PropertyJsonUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PropertyServiceTest {

    private final PropertyService propertyService = new PropertyService();

    @Test
    void shouldReturnFiveHundredWhenMetricSquareOfPropertyIsFiveHundred(){
        HomeRequest request = PropertyJsonUtil.getHomeRequestFromFile();

        PropertyResponse response = propertyService.calculate(request);

        assertEquals(500, response.getSquareMetersTotal());
    }
}