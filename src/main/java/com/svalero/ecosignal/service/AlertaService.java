package com.svalero.ecosignal.service;

import com.svalero.ecosignal.domain.Alerta;
import com.svalero.ecosignal.domain.Medicion;
import com.svalero.ecosignal.exception.AlertaNotFoundException;
import com.svalero.ecosignal.exception.MedicionNotFoundException;
import com.svalero.ecosignal.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;
    public Alerta add(Alerta alerta) {
        return alertaRepository.save(alerta);
    }
    public void delete(long id) throws AlertaNotFoundException {
        Alerta alerta = alertaRepository.findById(id)
                .orElseThrow(AlertaNotFoundException::new);
        alertaRepository.delete(alerta);
    }
    public List<Alerta> findAll(){
        return alertaRepository.findAll();
    }
    public Alerta modify(long id, Alerta alerta) throws AlertaNotFoundException {
        Alerta oldAlerta = alertaRepository.findById(id)
                .orElseThrow(AlertaNotFoundException::new);
        oldAlerta.setTitulo(alerta.getTitulo());
        oldAlerta.setDescripcion(alerta.getDescripcion());
        oldAlerta.setNivel(alerta.getNivel());
        oldAlerta.setUmbral(alerta.getUmbral());
        oldAlerta.setFechaHora(alerta.getFechaHora());
        return alertaRepository.save(oldAlerta);
    }
    public Alerta findById(long id) throws AlertaNotFoundException{
        return alertaRepository.findById(id)
                .orElseThrow(AlertaNotFoundException::new);

    }
}

