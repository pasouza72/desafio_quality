package com.meli.desafioquality.gateway.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomRequest {

    @JsonProperty("room_name")
    @NotEmpty(message = "O campo não pode estar vazio.")
    @Pattern(regexp = "^[A-Z]\\w*$", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    @Max(value = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres.")
    private String roomName;

    @JsonProperty("room_width")
    @NotEmpty(message = "A largura do cômodo não pode estar vazia.")
    @Max(value = 25, message = "A largura máxima permitida por cômodo é de 25 metros")
    private Double roomWidth;

    @JsonProperty("room_length")
    @NotEmpty(message = "O comprimento do cômodo não pode estar vazio.")
    @Max(value = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    private Double roomLength;
}
