package com.svalero.ecosignal.repository;

import com.svalero.ecosignal.domain.Alerta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertaRepository extends CrudRepository<Alerta, Long> {
    List<Alerta> findAll();
}
