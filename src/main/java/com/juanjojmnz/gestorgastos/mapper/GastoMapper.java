package com.juanjojmnz.gestorgastos.mapper;

import com.juanjojmnz.gestorgastos.dto.GastoDTO;
import com.juanjojmnz.gestorgastos.entity.Categoria;
import com.juanjojmnz.gestorgastos.entity.Gasto;

public class GastoMapper {

    public static GastoDTO toDTO(Gasto gasto) {
        GastoDTO dto = new GastoDTO();
        dto.setId(gasto.getId());
        dto.setDescripcion(gasto.getDescripcion());
        dto.setCantidad(gasto.getCantidad());
        dto.setFecha(gasto.getFecha());
        if (gasto.getCategoria() != null) {
            dto.setCategoriaId(gasto.getCategoria().getId());
            dto.setCategoriaNombre(gasto.getCategoria().getNombre());
        }
        return dto;
    }

    public static Gasto toEntity(GastoDTO dto) {
        Gasto gasto = new Gasto();
        gasto.setId(dto.getId());
        gasto.setDescripcion(dto.getDescripcion());
        gasto.setCantidad(dto.getCantidad());
        gasto.setFecha(dto.getFecha());
        
        // Crear objeto Categoria si hay ID o nombre
        if (dto.getCategoriaId() != null || dto.getCategoriaNombre() != null) {
            Categoria categoria = new Categoria();
            categoria.setId(dto.getCategoriaId());
            categoria.setNombre(dto.getCategoriaNombre());
            gasto.setCategoria(categoria);
        }
        
        return gasto;
    }
}