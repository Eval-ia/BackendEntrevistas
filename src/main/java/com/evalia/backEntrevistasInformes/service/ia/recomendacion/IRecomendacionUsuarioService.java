package com.evalia.backEntrevistasInformes.service.ia.recomendacion;

import com.evalia.backEntrevistasInformes.model.ia.recomendacion.ChatResponseDTO;

public interface IRecomendacionUsuarioService {
    ChatResponseDTO recomendarUsuariosParaPuesto(Long idPuesto);
}
