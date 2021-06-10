package com.meli.desafioquality.gateway.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomRequest {

    @JsonProperty("room_name")
    @NotEmpty(message = "O campo não pode estar vazio.")
    @Pattern(regexp = "^[A-Z]\\w*$", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    @Size(max = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres.")
    private String roomName;

    @JsonProperty("room_width")
    @DecimalMin(value = "1.0", message = "A largura mínima é 1 metro")
    @DecimalMax(value = "25.0", message = "A largura máxima permitida por cômodo é de 25 metros")
    private Double roomWidth;

    @JsonProperty("room_length")
    @DecimalMax(value = "33.0", message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    @DecimalMin(value = "1.0", message = "O comprimento mínimo por como é 1 metro")
    private Double roomLength;

    @Override
    public String toString() {
        return "{" +
                "\"roomName\":\"" + roomName + "\"" +
                "\"roomWidth\":" + roomWidth +
                ", \"roomLength\":" + roomLength +
                '}';
    }
}
