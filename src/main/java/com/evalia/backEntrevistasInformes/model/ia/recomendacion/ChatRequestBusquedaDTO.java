package com.evalia.backEntrevistasInformes.model.ia.recomendacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatRequestBusquedaDTO {
    private Long idCategoria;
    private Long idNivel;
}
