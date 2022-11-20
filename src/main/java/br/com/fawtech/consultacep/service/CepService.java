package br.com.fawtech.consultacep.service;

import br.com.fawtech.consultacep.api.client.ViaCepClient;
import br.com.fawtech.consultacep.api.converter.CepDTOConverter;
import br.com.fawtech.consultacep.model.Cep;
import br.com.fawtech.consultacep.repository.CepRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CepService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CepService.class);

    @Autowired
    private CepRepository repository;

    @Autowired
    private ViaCepClient client;

    @Autowired
    private CepDTOConverter converter;

    public Cep buscarCep(String cep) {
        Optional<Cep> cepDb = repository.findByCep(cep);

        return cepDb.orElseGet(() -> {
            LOGGER.info("Buscando CEP no ViaCep");
            Cep cepClient = converter.convert(client.buscarCep(cep));
            repository.save(cepClient);
            return cepClient;
        });
    }
}
