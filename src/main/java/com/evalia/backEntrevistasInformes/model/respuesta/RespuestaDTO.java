package com.evalia.backEntrevistasInformes.model.respuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaDTO {
    private Long entrevistaId;
    private Long idPregunta;
    private Long idPreguntaPersonalizada;
    private String textoRespuesta;
}
