package br.com.fawtech.consultacep.repository;

import br.com.fawtech.consultacep.model.Cep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {

    Optional<Cep> findByCep(String cep);
}
