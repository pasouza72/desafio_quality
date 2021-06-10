package com.meli.desafioquality.gateway.controller;

import com.meli.desafioquality.gateway.model.request.HomeRequest;
import com.meli.desafioquality.gateway.model.response.RoomResponse;
import com.meli.desafioquality.service.PropertyRoomCalculateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
public class PropertyRoomCalculateController extends PropertyCalculateController{

    private final PropertyRoomCalculateService service;

    @PostMapping("/calculate/room")
    public ResponseEntity<List<RoomResponse>> calculate(@RequestBody @Valid HomeRequest request){
        List<RoomResponse> response = service.calculate(request);

        return ResponseEntity.ok(response);
    }
}
