package com.juanjojmnz.gestorgastos.mapper;

import com.juanjojmnz.gestorgastos.dto.CategoriaDTO;
import com.juanjojmnz.gestorgastos.entity.Categoria;
import com.juanjojmnz.gestorgastos.entity.Gasto;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;

public class CategoriaMapper {
    
    public static CategoriaDTO toDTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNombre(categoria.getNombre());
        
        if (!categoria.getGastos().isEmpty()) {
            // Obtiene estadísticas de los gastos
            DoubleSummaryStatistics stats = categoria.getGastos().stream()
                    .mapToDouble(Gasto::getCantidad)
                    .summaryStatistics();
            
            dto.setTotalGastos(stats.getSum());
            dto.setNumeroGastos((int) stats.getCount());
            dto.setGastoPromedio(stats.getAverage());
            dto.setGastoMaximo(stats.getMax());
            dto.setGastoMinimo(stats.getMin());
            
            // Encuentra las fechas del primer y último gasto
            dto.setFechaUltimoGasto(
                categoria.getGastos().stream()
                    .max(Comparator.comparing(Gasto::getFecha))
                    .map(Gasto::getFecha)
                    .orElse(null)
            );
            
            dto.setFechaPrimerGasto(
                categoria.getGastos().stream()
                    .min(Comparator.comparing(Gasto::getFecha))
                    .map(Gasto::getFecha)
                    .orElse(null)
            );
        } else {
            // Inicializa valores por defecto si no hay gastos
            dto.setTotalGastos(0);
            dto.setNumeroGastos(0);
            dto.setGastoPromedio(0);
            dto.setGastoMaximo(0);
            dto.setGastoMinimo(0);
            dto.setFechaUltimoGasto(null);
            dto.setFechaPrimerGasto(null);
        }
        
        return dto;
    }
}