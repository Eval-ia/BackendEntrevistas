package com.evalia.backEntrevistasInformes.service.entrevistas;

import com.evalia.backEntrevistasInformes.model.entrevista.EntrevistaFinalizadaDTO;

public interface IEntrevistasService {
    Long finalizarEntrevista(EntrevistaFinalizadaDTO dto);
}
