package com.meli.desafioquality.gateway.controller;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.gateway.model.response.PropertyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/props")
public interface PropertyController {

    ResponseEntity<PropertyResponse> calculate(HomeRequest request);
}
