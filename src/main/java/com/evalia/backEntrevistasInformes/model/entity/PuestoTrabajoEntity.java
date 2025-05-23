package com.evalia.backEntrevistasInformes.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name ="Puesto")
public class PuestoTrabajoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPuesto;

    private String nombre;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private CategoriaEntity categoria;

    @ManyToOne
    @JoinColumn(name = "idNivel")
    private NivelEntity nivel;
}
