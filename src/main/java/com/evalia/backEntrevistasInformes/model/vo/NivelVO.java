package com.evalia.backEntrevistasInformes.model.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "Nivel")
public class NivelVO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idNivel;

    String nombre;
}
