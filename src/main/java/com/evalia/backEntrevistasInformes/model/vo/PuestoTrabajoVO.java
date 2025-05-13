package com.evalia.backEntrevistasInformes.model.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name ="Puesto")
public class PuestoTrabajoVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPuesto;

    private String nombre;

    private String descripcion;

    @JoinColumn(name = "id_categoria")
    private CategoriaVO categoria;

    @ManyToOne
    @JoinColumn(name = "id_nivel")
    private NivelVO nivel;
}
