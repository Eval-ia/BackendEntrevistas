package com.evalia.backEntrevistasInformes.model.entity;

import com.evalia.backEntrevistasInformes.model.NombreCategoriaTecnologia;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="CategoriaTecnologia")
public class Categoria_Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoriaTecnologi;

    @Enumerated(EnumType.STRING)
    private NombreCategoriaTecnologia nombre;
<<<<<<< HEAD
=======
    
    @OneToMany(mappedBy = "categoriaTecnologia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CategoriaEntity> categorias;
>>>>>>> 089c16cd28ab5e5d6cb867a56df3b063b8bea4e0
}
