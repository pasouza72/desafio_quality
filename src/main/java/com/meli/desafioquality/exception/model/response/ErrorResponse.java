package com.meli.desafioquality.exception.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private String code;
    private String message;
    private String field;

    private List<ErrorResponse> errors;

    public ErrorResponse(){
        errors = new ArrayList<>();
    }

    public ErrorResponse(String field, String message) {
        this.field = field;
        this.message = message;
    }

}
