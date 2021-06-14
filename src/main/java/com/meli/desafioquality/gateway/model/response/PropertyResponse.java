package com.meli.desafioquality.gateway.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PropertyResponse {

    private Double squareMetersTotal;

    private Double value;

    @Override
    public String toString() {
        return "{" +
                "\"squareMetersTotal\":" + squareMetersTotal +
                ",\"value\":" + value +
                '}';
    }
}
