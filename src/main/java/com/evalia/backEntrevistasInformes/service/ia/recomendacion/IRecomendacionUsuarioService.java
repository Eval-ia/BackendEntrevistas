package com.evalia.backEntrevistasInformes.service.ia.recomendacion;

import java.util.List;

import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;
import com.evalia.backEntrevistasInformes.model.ia.recomendacion.ChatResponseDTO;

public interface IRecomendacionUsuarioService {
    ChatResponseDTO recomendarUsuariosPorCategoriaYNivel(Long idCategoria, Long idNivel);
    ChatResponseDTO recomendarUsuariosPorPregunta(String mensaje);
     List<UsuarioEntity> obtenerUsuariosConInforme();
}
