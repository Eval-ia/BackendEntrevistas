package com.evalia.backEntrevistasInformes.model.entity;

import java.util.List;

import com.evalia.backEntrevistasInformes.model.NombreCategoriaTecnologia;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name="CategoriaTecnologia")
public class Categoria_Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoriaTecnologia;

    @Enumerated(EnumType.STRING)
    private NombreCategoriaTecnologia nombre;


    @OneToMany(mappedBy = "categoriaTecnologia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CategoriaEntity> categorias;
}
