package com.juanjojmnz.gestorgastos.controller;

import com.juanjojmnz.gestorgastos.dto.GastoDTO;
import com.juanjojmnz.gestorgastos.entity.Gasto;
import com.juanjojmnz.gestorgastos.mapper.GastoMapper;
import com.juanjojmnz.gestorgastos.service.GastoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gastos")
@RequiredArgsConstructor
public class GastoController {

    private final GastoService gastoService;

    @PostMapping
    public GastoDTO crearGasto(@RequestBody GastoDTO gastoDTO) {
        Gasto gasto = GastoMapper.toEntity(gastoDTO);
        Gasto guardado = gastoService.guardarGasto(gasto);
        return GastoMapper.toDTO(guardado);
    }

    @GetMapping
    public List<GastoDTO> listarGastos() {
        return gastoService.obtenerTodos().stream()
                .map(GastoMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public GastoDTO obtenerGastoPorId(@PathVariable Long id) {
        Gasto gasto = gastoService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Gasto no encontrado"));
        return GastoMapper.toDTO(gasto);
    }

    @PutMapping("/{id}")
    public GastoDTO actualizarGasto(@PathVariable Long id, @RequestBody GastoDTO gastoDTO) {
        Gasto gastoActualizado = gastoService.actualizarGasto(id, GastoMapper.toEntity(gastoDTO));
        return GastoMapper.toDTO(gastoActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarGasto(@PathVariable Long id) {
        gastoService.eliminarGasto(id);
    }

    @PatchMapping("/{id}")
    public GastoDTO actualizarParcialmente(@PathVariable Long id, @RequestBody GastoDTO gastoParcialDTO) {
        Gasto gastoExistente = gastoService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Gasto no encontrado"));

        if (gastoParcialDTO.getDescripcion() != null) {
            gastoExistente.setDescripcion(gastoParcialDTO.getDescripcion());
        }
        if (gastoParcialDTO.getCantidad() != 0) {
            gastoExistente.setCantidad(gastoParcialDTO.getCantidad());
        }
        if (gastoParcialDTO.getFecha() != null) {
            gastoExistente.setFecha(gastoParcialDTO.getFecha());
        }
        if (gastoParcialDTO.getCategoriaId() != null) {

        }

        Gasto actualizado = gastoService.guardarGasto(gastoExistente);
        return GastoMapper.toDTO(actualizado);
    }
}