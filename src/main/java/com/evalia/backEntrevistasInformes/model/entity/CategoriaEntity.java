package com.evalia.backEntrevistasInformes.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
<<<<<<< HEAD
    private CategoriaTecnologiaEntity categoriaTecnologia;
=======
    private Categoria_Tecnologia categoriaTecnologia;
<<<<<<< HEAD

=======
>>>>>>> main
>>>>>>> 089c16cd28ab5e5d6cb867a56df3b063b8bea4e0
}
