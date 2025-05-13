package com.evalia.backEntrevistasInformes.model.vo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "Entrevistas")
public class EntrevistaVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntrevista;

    @ManyToOne
    @JoinColumn(name = "idEntrevistador")
    private UsuarioVO entrevistador;

    @ManyToOne
    @JoinColumn(name = "idCandidato")
    private UsuarioVO candidato;

    @ManyToOne
    @JoinColumn(name = "idPuesto")
    private PuestoTrabajoVO puesto;

    private LocalDate fecha;
}
