package com.juanjojmnz.gestorgastos.service;

import com.juanjojmnz.gestorgastos.entity.Gasto;
import java.util.List;
import java.util.Optional;

public interface GastoService {
    Gasto guardarGasto(Gasto gasto);
    List<Gasto> obtenerTodos();
    Optional<Gasto> obtenerPorId(Long id);
    Gasto actualizarGasto(Long id, Gasto gastoActualizado);
    void eliminarGasto(Long id);
}
