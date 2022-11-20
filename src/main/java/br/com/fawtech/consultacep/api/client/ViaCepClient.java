package br.com.fawtech.consultacep.api.client;

import br.com.fawtech.consultacep.api.dto.CepDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ViaCep", url = "https://viacep.com.br/ws")
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    CepDTO buscarCep(@PathVariable String cep);
}
