package com.evalia.backEntrevistasInformes.service.ia.informe;

import com.evalia.backEntrevistasInformes.model.ia.recomendacion.ChatRequestDTO;
import com.evalia.backEntrevistasInformes.model.ia.recomendacion.ChatResponseDTO;

public interface IInformeEntrevistaService {
    void generarInformeDesdeEntrevista(Long idEntrevista);
}
