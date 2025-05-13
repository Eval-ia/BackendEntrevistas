package com.evalia.backEntrevistasInformes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name ="Usuarios")
public class UsuarioVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombre;

    private String email;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @Column(columnDefinition = "LONGTEXT")
    private String informe;

}
