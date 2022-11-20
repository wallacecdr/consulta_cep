package br.com.fawtech.consultacep.api.controller;

import br.com.fawtech.consultacep.api.converter.CepDTOConverter;
import br.com.fawtech.consultacep.api.dto.CepDTO;
import br.com.fawtech.consultacep.service.CepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {

    private final CepService service;
    private final CepDTOConverter converter;

    public CepController(CepService service,
                         CepDTOConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<CepDTO> buscarCep(@PathVariable String cep) {
        return ResponseEntity.ok(converter.convert(this.service.buscarCep(cep)));
    }

}
