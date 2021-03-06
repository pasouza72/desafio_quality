package com.meli.desafioquality.gateway.repository;

import com.meli.desafioquality.exception.DistrictNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DistrictRepository {

    private static final Map<String, Double> districts = new HashMap<>();

    static {
        districts.put("Bairro1", 5.0);
        districts.put("Bairro2", 6.0);
        districts.put("Bairro3", 7.0);
    }

    public Double findDistrictPriceByName(String propDistrict) {
        Double value = districts.get(propDistrict);

        if(value == null){
            throw  new DistrictNotFoundException(String.format("District %s não encontrado", propDistrict));
        }

        return value;
    }
}
