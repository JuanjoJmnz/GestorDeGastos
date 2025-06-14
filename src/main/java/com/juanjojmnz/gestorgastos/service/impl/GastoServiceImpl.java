package com.juanjojmnz.gestorgastos.service.impl;

import com.juanjojmnz.gestorgastos.entity.Categoria;
import com.juanjojmnz.gestorgastos.entity.Gasto;
import com.juanjojmnz.gestorgastos.repository.CategoriaRepository;
import com.juanjojmnz.gestorgastos.repository.GastoRepository;
import com.juanjojmnz.gestorgastos.service.GastoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GastoServiceImpl implements GastoService {

    private final GastoRepository gastoRepository;
    private final CategoriaRepository categoriaRepository;

    @Override
    public Gasto guardarGasto(Gasto gasto) {
        if (gasto.getCategoria() != null) {
            Categoria categoria = null;
            
            if (gasto.getCategoria().getId() != null) {
                categoria = categoriaRepository.findById(gasto.getCategoria().getId())
                        .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + 
                                gasto.getCategoria().getId()));
            }
            else if (gasto.getCategoria().getNombre() != null && !gasto.getCategoria().getNombre().isEmpty()) {
                categoria = categoriaRepository.findByNombre(gasto.getCategoria().getNombre())
                        .orElseThrow(() -> new RuntimeException("Categoría no encontrada con nombre: " + 
                                gasto.getCategoria().getNombre()));
            }
            
            gasto.setCategoria(categoria);
        }
        return gastoRepository.save(gasto);
    }

    @Override
    public List<Gasto> obtenerTodos() {
        return gastoRepository.findAll();
    }

    @Override
    public Optional<Gasto> obtenerPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public Gasto actualizarGasto(Long id, Gasto gastoActualizado) {
        return null;
    }

    @Override
    public void eliminarGasto(Long id) {

    }
}