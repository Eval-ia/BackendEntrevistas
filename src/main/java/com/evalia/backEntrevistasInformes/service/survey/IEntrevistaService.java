package com.evalia.backEntrevistasInformes.service.survey;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;
import java.util.List;
import java.util.Optional;

public interface IEntrevistaService {
    List<EntrevistaEntity> findAll();
    Optional<EntrevistaEntity> findById(Long id);
    EntrevistaEntity save(EntrevistaEntity entrevista);
    void deleteById(Long id);
}
