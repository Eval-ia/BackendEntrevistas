package com.evalia.backEntrevistasInformes.service.survey;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaPersonalizadaEntity;

import java.util.List;

public interface PreguntaPersonalizadaService {
    PreguntaPersonalizadaEntity guardar(String texto, Long idEntrevista);
    List<PreguntaPersonalizadaEntity> listarPorEntrevista(Long idEntrevista);
    void eliminar(Long idPregunta);
}
