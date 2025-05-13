package com.evalia.backEntrevistasInformes.model.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "Tecnologia")
public class Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTecnologia;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idCategoriaTecnologia") // nombre de la columna foránea en la tabla "Tecnologia"
    private Categoria_Tecnologia categoria;

}
