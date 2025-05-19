package com.evalia.backEntrevistasInformes.model.entrevista;

import java.util.List;

import com.evalia.backEntrevistasInformes.model.preguntas.PreguntaPersonalizadaDTO;
import com.evalia.backEntrevistasInformes.model.preguntas.PreguntaRespuestaDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntrevistaFinalizadaDTO {
    private Long idEntrevistador;
    private Long idCandidato;
    private Long idPuesto;
    private List<PreguntaPersonalizadaDTO> preguntasPersonalizadas;
    private List<PreguntaRespuestaDTO> respuestas;
}

