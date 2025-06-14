package com.juanjojmnz.gestorgastos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GastoDTO {
    private Long id;
    private String descripcion;
    private double cantidad;
    private LocalDate fecha;
    private Long categoriaId;
    private String categoriaNombre;
}