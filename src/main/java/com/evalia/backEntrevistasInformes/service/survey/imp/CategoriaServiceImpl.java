package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;
import com.evalia.backEntrevistasInformes.repository.CategoriaRepository;

import com.evalia.backEntrevistasInformes.service.survey.CategoriaService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaEntity> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<CategoriaEntity> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public CategoriaEntity save(CategoriaEntity categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }

 @Override
    public CategoriaEntity guardarCategoria(String nombre) {
        return categoriaRepository.findByNombreIgnoreCase(nombre)
                .orElseGet(() -> {
                    CategoriaEntity nueva = new CategoriaEntity();
                    nueva.setNombre(nombre);
                    return categoriaRepository.save(nueva);
                });
    }
}
