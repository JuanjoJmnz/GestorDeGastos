package com.juanjojmnz.gestorgastos.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CategoriaDTO {
    private Long id;
    private String nombre;
    private double totalGastos;
    private int numeroGastos;
    private double gastoPromedio;
    private double gastoMaximo;
    private double gastoMinimo;
    private LocalDate fechaUltimoGasto;
    private LocalDate fechaPrimerGasto;
}