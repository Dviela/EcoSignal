package com.svalero.ecosignal.service;

import com.svalero.ecosignal.domain.Alerta;
import com.svalero.ecosignal.exception.AlertaNotFoundException;
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
}
