package com.evalia.backEntrevistasInformes.service.survey;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaEntity;

public interface IPreguntaService {
    List<PreguntaEntity> findAll();
    Optional<PreguntaEntity> findById(Long id);
    PreguntaEntity save(PreguntaEntity pregunta);
    void deleteById(Long id);
    List<PreguntaEntity> obtenerPorPuesto(Long idPuesto);
    List<PreguntaEntity> obtenerGenericas();
}
