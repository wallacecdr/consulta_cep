package br.com.fawtech.consultacep.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CepDTO {

    private String cep;
    @JsonProperty("logradouro")
    private String address;
    @JsonProperty("bairro")
    private String district;
    @JsonProperty("localidade")
    private String city;
}
