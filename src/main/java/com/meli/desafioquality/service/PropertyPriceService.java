package com.meli.desafioquality.service;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.gateway.model.response.PropertyResponse;
import com.meli.desafioquality.gateway.repository.DistrictRepository;
import com.meli.desafioquality.util.property.SquareMeterUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PropertyPriceService {

    private final DistrictRepository districtRepository;

    public PropertyResponse calculate(HomeRequest request) {
        Double priceOfDistrict = districtRepository.findDistrictPriceByName(request.getPropDistrict());

        double squareMetersTotal = SquareMeterUtil.calculate(request);

        Double value = squareMetersTotal * priceOfDistrict;

        return PropertyResponse.builder().value(value).build();
    }
}
