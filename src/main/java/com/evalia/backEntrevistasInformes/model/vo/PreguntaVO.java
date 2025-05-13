package com.evalia.backEntrevistasInformes.model.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "Pregunta")
public class PreguntaVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPregunta;

    private String texto;

    private Boolean esGenerica;

    @ManyToOne
    @JoinColumn(name = "id_puesto")
    private PuestoTrabajoVO puesto;
}
