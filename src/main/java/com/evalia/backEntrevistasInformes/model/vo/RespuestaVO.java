package com.evalia.backEntrevistasInformes.model.vo;

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
public class RespuestaVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRespuesta;

    @ManyToOne
    @JoinColumn(name = "idEntrevista")
    private EntrevistaVO entrevista;

    @ManyToOne
    @JoinColumn(name = "idPregunta")
    private PreguntaVO pregunta;

    @ManyToOne
    @JoinColumn(name = "idPreguntaPersonalizada")
    private PreguntaPersonalizadaVO preguntaPersonalizada;

    @Column(columnDefinition = "TEXT")
    private String textoRespuesta;
}
