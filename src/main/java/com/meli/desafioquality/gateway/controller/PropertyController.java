package com.meli.desafioquality.gateway.controller;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.gateway.model.response.PropertyResponse;
import com.meli.desafioquality.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/props")
public class PropertyController {

    private final PropertyService propertyService;

    @PostMapping(value = "/calculation/square/meters")
    public ResponseEntity<PropertyResponse> calculate(@RequestBody @Valid HomeRequest request){
        PropertyResponse response = propertyService.calculate(request);

        return ResponseEntity.ok(response);
    }
}
