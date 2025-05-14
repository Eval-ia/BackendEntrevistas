package com.evalia.backEntrevistasInformes.service.ia.recomendacion;

import com.evalia.backEntrevistasInformes.model.ia.recomendacion.ChatResponseDTO;

public interface IRecomendacionUsuarioService {
    ChatResponseDTO recomendarUsuariosPorCategoriaYNivel(Long idCategoria, Long idNivel);
    ChatResponseDTO recomendarUsuariosPorPregunta(String mensaje);
}
