package com.evalia.backEntrevistasInformes.model.entity;

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
@Entity(name = "Categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCategoria;

    String nombre;

    @ManyToOne
    @JoinColumn(name = "id_categoria_tecnologia")
    private Categoria_Tecnologia categoriaTecnologia;

}
