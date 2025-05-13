package com.evalia.backEntrevistasInformes.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name ="Pregunta_personalizada")
public class PreguntaPersonalizadaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPreguntaPersonalizada;

    @ManyToOne
    @JoinColumn(name = "idEntrevista")
    private EntrevistaEntity entrevista;

    private String texto;
}
