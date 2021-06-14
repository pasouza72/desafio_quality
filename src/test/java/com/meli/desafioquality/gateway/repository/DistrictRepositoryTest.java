package com.meli.desafioquality.gateway.repository;

import com.meli.desafioquality.exception.DistrictNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class DistrictRepositoryTest {

    private final DistrictRepository districtRepository = new DistrictRepository();

    @Test
    void shouldReturnNumberWhenDistrictExist(){
        Double value = districtRepository.findDistrictPriceByName("Bairro1");

        assertEquals(5.0, value);
    }

    @Test
    void shouldReturnExceptionWhenDistrictNotExist(){

        assertThrows(DistrictNotFoundException.class,
                () -> districtRepository.findDistrictPriceByName("notExistentDistrict"));
    }

}