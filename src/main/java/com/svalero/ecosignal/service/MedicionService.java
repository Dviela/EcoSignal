package com.svalero.ecosignal.service;

import com.svalero.ecosignal.domain.Medicion;
import com.svalero.ecosignal.exception.AlertaNotFoundException;
import com.svalero.ecosignal.exception.MedicionNotFoundException;
import com.svalero.ecosignal.repository.MedicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicionService {

    @Autowired
    private MedicionRepository medicionRepository;

    public Medicion add(Medicion medicion) {
        return medicionRepository.save(medicion);
    }
    public void delete(long id) throws AlertaNotFoundException, MedicionNotFoundException {
        Medicion medicion = medicionRepository.findById(id)
                .orElseThrow(MedicionNotFoundException::new);
        medicionRepository.delete(medicion);
    }

}
