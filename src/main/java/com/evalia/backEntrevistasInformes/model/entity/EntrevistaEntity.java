package com.evalia.backEntrevistasInformes.model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "Entrevistas")
public class EntrevistaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntrevista;

    @ManyToOne
    @JoinColumn(name = "idEntrevistador")
    private UsuarioEntity entrevistador;

    @ManyToOne
    @JoinColumn(name = "idCandidato")
    private UsuarioEntity candidato;

    @ManyToOne
    @JoinColumn(name = "idPuesto")
    private PuestoTrabajoEntity puesto;

    private LocalDate fecha;
    @OneToMany(mappedBy = "entrevista", cascade = CascadeType.ALL, orphanRemoval = true)
private List<RespuestaEntity> respuestas = new ArrayList<>();

}
