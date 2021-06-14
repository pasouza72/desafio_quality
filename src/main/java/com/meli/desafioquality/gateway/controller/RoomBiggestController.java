package com.meli.desafioquality.gateway.controller;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.gateway.model.response.RoomResponse;
import com.meli.desafioquality.service.RoomBiggestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class RoomBiggestController extends PropertyCalculateController{

    private final RoomBiggestService roomBiggestService;

    @PostMapping(value = "/calculation/room/biggest")
    public ResponseEntity<RoomResponse> calculate(@RequestBody @Valid HomeRequest request){
        RoomResponse response = roomBiggestService.calculate(request);

        return ResponseEntity.ok(response);
    }
}
