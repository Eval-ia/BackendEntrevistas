package com.evalia.backEntrevistasInformes.model.preguntas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaRespuestaDTO {
    private Long idPregunta;
private String textoPreguntaPersonalizada; // NUEVO
private String respuesta;

}

