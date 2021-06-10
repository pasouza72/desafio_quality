package com.meli.desafioquality.service;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.gateway.model.response.PropertyResponse;
import com.meli.desafioquality.gateway.repository.DistrictRepository;
import com.meli.desafioquality.util.PropertyJsonUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PropertyPriceServiceTest {

    @Mock private DistrictRepository districtRepository;
    @InjectMocks private PropertyPriceService propertyPriceService;

    @Test
    void shouldReturn2500WhenSquareMeterTotalIs500AndPriceOfDistrictIs5(){
        Mockito.when(districtRepository.findDistrictPriceByName("Bairro1"))
                .thenReturn(5.0);

        HomeRequest request = PropertyJsonUtil.getHomeRequestFromFile();

        PropertyResponse response = propertyPriceService.calculate(request);

        Assertions.assertEquals(2500.0, response.getValue());
    }

}