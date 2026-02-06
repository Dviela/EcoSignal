package com.svalero.ecosignal.controller;

import com.svalero.ecosignal.domain.Alerta;
import com.svalero.ecosignal.domain.Medicion;
import com.svalero.ecosignal.exception.AlertaNotFoundException;
import com.svalero.ecosignal.exception.MedicionNotFoundException;
import com.svalero.ecosignal.service.AlertaService;
import com.svalero.ecosignal.service.MedicionService;
import org.hibernate.engine.jdbc.dialect.spi.DatabaseMetaDataDialectResolutionInfoAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlertaController {
    @Autowired
    private AlertaService alertaService;

    @GetMapping("/alerta")
    public List<Alerta> getAll() {
        List<Alerta> allAlerta = alertaService.findAll();
        return allAlerta;
    }
    @PostMapping("/alerta")
    public void addAlerta(@RequestBody Alerta alerta){
        alertaService.add(alerta);
    }
    @PutMapping("/alerta/{id}")
    public ResponseEntity<Alerta> modifyAlerta(@PathVariable long id, @RequestBody Alerta alerta) throws AlertaNotFoundException{
        Alerta newalerta = alertaService.modify(id,alerta);
        return ResponseEntity.ok(newalerta);
    }
    @DeleteMapping("/alerta/{id}")
    public ResponseEntity<Void> deleteAlerta(@PathVariable long id) throws AlertaNotFoundException {
        alertaService.delete(id);
        return ResponseEntity.noContent().build();
}
    }
