package com.evalia.backEntrevistasInformes.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "Respuesta")
public class RespuestaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRespuesta;

    @ManyToOne
    @JoinColumn(name = "idEntrevista")
    private EntrevistaEntity entrevista;

    @ManyToOne
    @JoinColumn(name = "idPregunta")
    private PreguntaEntity pregunta;

    @ManyToOne
    @JoinColumn(name = "idPreguntaPersonalizada")
    private PreguntaPersonalizadaEntity preguntaPersonalizada;

    @Column(columnDefinition = "TEXT")
    private String textoRespuesta;
    
   
}
