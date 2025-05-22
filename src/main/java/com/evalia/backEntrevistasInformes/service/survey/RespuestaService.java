package com.evalia.backEntrevistasInformes.service.survey;

import java.util.List;

import com.evalia.backEntrevistasInformes.model.entity.RespuestaEntity;

public interface RespuestaService {
    void guardarRespuestas(List<RespuestaEntity> respuestas);
}

