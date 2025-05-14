package com.evalia.backEntrevistasInformes.service.survey;

import com.evalia.backEntrevistasInformes.model.entity.TecnologiaEntity;
import java.util.List;
import java.util.Optional;

public interface ICategoriaService {
    List<TecnologiaEntity> findAll();
    Optional<TecnologiaEntity> findById(Long id);
    TecnologiaEntity save(TecnologiaEntity categoria);
    void deleteById(Long id);
}
