package com.svalero.ecosignal.service;

import com.svalero.ecosignal.domain.Medicion;
import com.svalero.ecosignal.exception.AlertaNotFoundException;
import com.svalero.ecosignal.exception.MedicionNotFoundException;
import com.svalero.ecosignal.repository.MedicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicionService {

    @Autowired
    private MedicionRepository medicionRepository;

    public Medicion add(Medicion medicion) {
        return medicionRepository.save(medicion);
    }
    public void delete(long id) throws MedicionNotFoundException {
        Medicion medicion = medicionRepository.findById(id)
                .orElseThrow(MedicionNotFoundException::new);
        medicionRepository.delete(medicion);
    }

    public List<Medicion> findAll(){
        List<Medicion> allMedicion = medicionRepository.findAll();
        return allMedicion;
    }
    public Medicion modify(long id, Medicion medicion) throws MedicionNotFoundException{
        Medicion oldMedicion = medicionRepository.findById(id)
                .orElseThrow(MedicionNotFoundException::new);
        oldMedicion.setTipo(medicion.getTipo());
        oldMedicion.setValor(medicion.getValor());
        oldMedicion.setUnidad(medicion.getUnidad());
        oldMedicion.setFechaHora(medicion.getFechaHora());
        return medicionRepository.save(oldMedicion);
    }
    public Medicion findById(long id) throws MedicionNotFoundException{
        return medicionRepository.findById(id)
                .orElseThrow(MedicionNotFoundException::new);

    }

}
