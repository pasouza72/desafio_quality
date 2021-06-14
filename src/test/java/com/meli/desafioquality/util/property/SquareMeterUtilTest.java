package com.meli.desafioquality.util.property;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.util.PropertyJsonUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SquareMeterUtilTest {

    @Test
    void shouldReturnSquareMeterCalculated(){
        HomeRequest homeRequestFromFile = PropertyJsonUtil.getHomeRequestFromFile();

        Double calculate = SquareMeterUtil.calculate(homeRequestFromFile);

        assertEquals(500.0, calculate);
    }


}