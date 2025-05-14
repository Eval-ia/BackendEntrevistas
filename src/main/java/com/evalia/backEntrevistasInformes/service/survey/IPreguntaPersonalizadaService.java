package com.evalia.backEntrevistasInformes.service.survey;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaPersonalizadaEntity;
import java.util.List;
import java.util.Optional;

public interface IPreguntaPersonalizadaService {
    List<PreguntaPersonalizadaEntity> findAll();
    Optional<PreguntaPersonalizadaEntity> findById(Long id);
    PreguntaPersonalizadaEntity save(PreguntaPersonalizadaEntity preguntaPersonalizada);
    void deleteById(Long id);
}
