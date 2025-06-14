package com.juanjojmnz.gestorgastos.service;

import com.juanjojmnz.gestorgastos.dto.CategoriaDTO;
import com.juanjojmnz.gestorgastos.entity.Categoria;
import com.juanjojmnz.gestorgastos.mapper.CategoriaMapper;
import com.juanjojmnz.gestorgastos.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    
    private final CategoriaRepository categoriaRepository;
    
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
    
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }
    
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }

    public List<CategoriaDTO> obtenerTodas() {
        return categoriaRepository.findAll().stream()
                .map(CategoriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CategoriaDTO> findDTOById(Long id) {
        return categoriaRepository.findById(id)
                .map(CategoriaMapper::toDTO);
    }

}