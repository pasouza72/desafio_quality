package com.meli.desafioquality.gateway.model.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HomeRequest {

    @JsonProperty("prop_name")
    @NotEmpty( message = "O nome da propriedade não pode estar vazio.")
    @Pattern(regexp = "^[A-Z]\\w*$", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    @Size(max = 30, message = "O nome da propriedade não pode exceder 30 caracteres")
    private String propName;

    @JsonProperty("prop_district")
    @NotEmpty(message = "O bairro não pode estar vazio.")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    private String propDistrict;

    @Size(min = 1, message = "A propriedade precisa ter ao menos um cômodo")
    @Valid
    @NotNull
    private List<RoomRequest> rooms;

    @Override
    public String toString() {
        return "{" +
                " \"prop_name\": \"" + propName + "\"" +
                ", \"prop_district\":\"" + propDistrict + "\"" +
                ", \"rooms\":" + rooms +
                '}';
    }
}
