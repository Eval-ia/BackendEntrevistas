package com.evalia.backEntrevistasInformes.service.survey;

import com.evalia.backEntrevistasInformes.model.entity.PuestoTrabajoEntity;

public interface PuestoTrabajoService {
    PuestoTrabajoEntity crearOPreexistente(String tecnologia, String nivel);
}
