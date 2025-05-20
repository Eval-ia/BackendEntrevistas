package com.evalia.backEntrevistasInformes.service.survey;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;
import java.util.List;
import java.util.Optional;

public interface ICategoriaService {
    List<CategoriaEntity> findAll();
    Optional<CategoriaEntity> findById(Long id);
    CategoriaEntity save(CategoriaEntity categoria);
    void deleteById(Long id);
    CategoriaEntity guardarCategoria(String nombre);

}
