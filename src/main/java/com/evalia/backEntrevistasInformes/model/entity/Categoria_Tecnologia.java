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
    private Long idCategoriaTecnologia;

    @Enumerated(EnumType.STRING)
    private NombreCategoriaTecnologia nombre;
}
