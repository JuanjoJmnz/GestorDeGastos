package com.juanjojmnz.gestorgastos.repository;

import com.juanjojmnz.gestorgastos.entity.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Long> {
    // TODO: Añadir métodos personalizados más tarde
}