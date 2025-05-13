package com.evalia.backEntrevistasInformes.model.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name ="Pregunta_personalizada")
public class PreguntaPersonalizadaVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPreguntaPersonalizada;

    @ManyToOne
    @JoinColumn(name = "idEntrevista")
    private EntrevistaVO entrevista;

    private String texto;
}
