package com.evalia.backEntrevistasInformes.service.survey;

import com.evalia.backEntrevistasInformes.model.entity.RespuestaEntity;
import com.evalia.backEntrevistasInformes.model.respuesta.RespuestaDTO;

import java.util.List;
import java.util.Optional;

public interface IRespuestaService {
    List<RespuestaEntity> findAll();

    Optional<RespuestaEntity> findById(Long id);

    RespuestaEntity save(RespuestaEntity respuesta);

    void deleteById(Long id);

    void guardarRespuestas(List<RespuestaEntity> respuestas);

    void guardarRespuestasDesdeDTO(List<RespuestaDTO> dtos);
}
