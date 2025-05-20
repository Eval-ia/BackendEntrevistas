package com.evalia.backEntrevistasInformes.service.survey;

import com.evalia.backEntrevistasInformes.model.entity.PuestoTrabajoEntity;
import java.util.List;
import java.util.Optional;

public interface IPuestoTrabajoService {
    List<PuestoTrabajoEntity> findAll();
    Optional<PuestoTrabajoEntity> findById(Long id);
    PuestoTrabajoEntity save(PuestoTrabajoEntity puestoTrabajo);
    void deleteById(Long id);
    PuestoTrabajoEntity crearOPreexistente(String tecnologia, String nivel);

}
