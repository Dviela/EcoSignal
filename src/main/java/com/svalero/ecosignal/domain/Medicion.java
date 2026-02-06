package com.svalero.ecosignal.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "medicion")
public class Medicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String tipo;
    @Column
    private double valor;
    @Column
    private String unidad;
    @Column(name = "fecha_hora")
    private LocalDate fechaHora;
    @Column
    private boolean valida = true;


}
