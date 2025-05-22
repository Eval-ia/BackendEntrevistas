package com.evalia.backEntrevistasInformes.service.survey;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaEntity;

import java.util.List;

public interface PreguntaService {
    PreguntaEntity guardarPregunta(PreguntaEntity pregunta);
    List<PreguntaEntity> obtenerPorPuesto(Long idPuesto);
    public List<PreguntaEntity> obtenerGenericas();
}
