package com.evalia.backEntrevistasInformes.service.survey;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaEntity;
import java.util.List;
import java.util.Optional;

public interface IPreguntaService {
    List<PreguntaEntity> findAll();
    Optional<PreguntaEntity> findById(Long id);
    PreguntaEntity save(PreguntaEntity pregunta);
    void deleteById(Long id);
}
