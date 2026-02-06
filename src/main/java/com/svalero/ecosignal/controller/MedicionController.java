package com.svalero.ecosignal.controller;

import com.svalero.ecosignal.domain.Medicion;
import com.svalero.ecosignal.exception.MedicionNotFoundException;
import com.svalero.ecosignal.service.MedicionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicionController {
   @Autowired
   private MedicionService medicionService;
        @GetMapping("/medicion")
        public List<Medicion> getAll() {
            List<Medicion> allMedicion = medicionService.findAll();
        return allMedicion;
        }
        @PostMapping("/medicion")
        public void addMedicion(@RequestBody Medicion medicion){
            medicionService.add(medicion);
        }
        @PutMapping("/medicion/{id}")
        public ResponseEntity<Medicion> modifyMedicion(@PathVariable long id, @RequestBody Medicion medicion) throws MedicionNotFoundException{
            Medicion newmedicion = medicionService.modify(id,medicion);
            return ResponseEntity.ok(newmedicion);
        }
        @DeleteMapping("/medicion/{id}")
        public ResponseEntity<Void> deleteMedicion(@PathVariable long id) throws MedicionNotFoundException {
            medicionService.delete(id);
            return ResponseEntity.noContent().build();
        }
    }


