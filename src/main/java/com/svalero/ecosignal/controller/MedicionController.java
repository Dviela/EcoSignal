package com.svalero.ecosignal.controller;

import com.svalero.ecosignal.domain.Medicion;
import com.svalero.ecosignal.exception.MedicionNotFoundException;
import com.svalero.ecosignal.service.MedicionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
       @GetMapping("/medicion/{id}")
       public ResponseEntity<Medicion> get(@PathVariable long id) throws MedicionNotFoundException{
            Medicion medicion = medicionService.findById(id);
            return ResponseEntity.ok(medicion); //200 ok
        }

    @PostMapping("/medicion")
    public ResponseEntity<Medicion> addMedicion(@RequestBody Medicion medicion){
        Medicion nueva = medicionService.add(medicion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);   //201 created
    }

    @PutMapping("/medicion/{id}")
        public ResponseEntity<Medicion> modifyMedicion(@PathVariable long id, @RequestBody Medicion medicion) throws MedicionNotFoundException{
            Medicion newmedicion = medicionService.modify(id,medicion);
            return ResponseEntity.ok(newmedicion);
        }
        @DeleteMapping("/medicion/{id}")
        public ResponseEntity<Void> deleteMedicion(@PathVariable long id) throws MedicionNotFoundException {
            medicionService.delete(id);
            return ResponseEntity.noContent().build(); //204 no content
        }
    }


