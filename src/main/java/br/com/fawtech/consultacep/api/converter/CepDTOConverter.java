package br.com.fawtech.consultacep.api.converter;

import br.com.fawtech.consultacep.api.dto.CepDTO;
import br.com.fawtech.consultacep.model.Cep;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CepDTOConverter {

    public CepDTO convert(Cep cep){
        return Optional.ofNullable(cep)
                .map(source -> {
                    CepDTO cepDTO = new CepDTO();
                    cepDTO.setCep(source.getCep());
                    cepDTO.setAddress(source.getAddress());
                    cepDTO.setCity(source.getCity());
                    cepDTO.setDistrict(source.getDistrict());
                    return cepDTO;
                })
                .orElse(null);
    }

    public Cep convert(CepDTO cepDTO) {
        return Optional.ofNullable(cepDTO)
                .map(source -> Cep.builder()
                        .withCep(source.getCep().replace("-", ""))
                        .withAddress(source.getAddress())
                        .withDistrict(source.getDistrict())
                        .withCity(source.getCity())
                        .build()
                )
                .orElse(null);
    }
}
