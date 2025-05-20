package com.evalia.backEntrevistasInformes.service.survey;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaPersonalizadaEntity;
import java.util.List;
import java.util.Optional;

public interface IPreguntaPersonalizadaService {
    List<PreguntaPersonalizadaEntity> findAll();
    Optional<PreguntaPersonalizadaEntity> findById(Long id);
    PreguntaPersonalizadaEntity save(PreguntaPersonalizadaEntity preguntaPersonalizada);
    void deleteById(Long id);
    void eliminar(Long idPregunta);
    PreguntaPersonalizadaEntity guardar(String texto, Long idEntrevista);
    List<PreguntaPersonalizadaEntity> listarPorEntrevista(Long idEntrevista);

}
