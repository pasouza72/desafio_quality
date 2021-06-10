package com.meli.desafioquality.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.desafioquality.gateway.model.request.HomeRequest;

import java.io.File;
import java.io.IOException;

public class PropertyJsonUtil {
    private final static ObjectMapper mapper = new ObjectMapper();

    public static HomeRequest getHomeRequestFromFile() {
        try {
            return mapper.readValue(new File("src/test/resources/json/Property.json"), HomeRequest.class);
        } catch (IOException e) {
            throw new RuntimeException("Cannot Found file");
        }
    }

    public static String getHomeRequestAsStringFromFile() {
        try {
            return  mapper.writeValueAsString(getHomeRequestFromFile());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Cannot parse Object to json");
        }
    }
}
