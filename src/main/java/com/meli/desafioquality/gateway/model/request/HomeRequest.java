package com.meli.desafioquality.gateway.model.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HomeRequest {

    @JsonProperty("prop_name")
    @NotEmpty( message = "O nome da propriedade não pode estar vazio.")
    @Pattern(regexp = "^[A-Z]\\w*$", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    @Min(value = 1, message = "O nome da propriedade deve conter pelo menos um caractere")
    @Max(value = 30, message = "O nome da propriedade não pode exceder 30 caracteres")
    public String propName;

    @JsonProperty("prop_district")
    @NotEmpty(message = "O bairro não pode estar vazio.")
    @Max(value = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    public String propDistrict;


    public List<RoomRequest> rooms;

}
