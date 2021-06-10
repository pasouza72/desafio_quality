package com.meli.desafioquality.gateway.controller;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.gateway.model.response.PropertyResponse;
import com.meli.desafioquality.service.PropertyPriceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class PropertyPriceController implements PropertyController{

    private final PropertyPriceService propertyPriceService;

    @PostMapping(value = "/calculation/price")
    public ResponseEntity<PropertyResponse> calculate(@RequestBody @Valid HomeRequest request){
        PropertyResponse response = propertyPriceService.calculate(request);

        return ResponseEntity.ok(response);
    }

}
