package com.evalia.backEntrevistasInformes.model.ia.recomendacion;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatResponseDTO {
    private String mensaje;
    private List<Long> usuariosRecomendados;
}
