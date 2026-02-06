package com.svalero.ecosignal.repository;

import com.svalero.ecosignal.domain.Medicion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicionRepository extends CrudRepository<Medicion, Long> {
    List<Medicion> findAll();
}
