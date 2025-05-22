package com.evalia.backEntrevistasInformes.service.survey;

import java.util.List;
import java.util.Optional;

import com.evalia.backEntrevistasInformes.model.Rol;
import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;

public interface UsuarioService {
    UsuarioEntity crearUsuario(String nombre, Rol rol);
    List<UsuarioEntity> findAll();
    Optional<UsuarioEntity> findById(Long id);
    UsuarioEntity save(UsuarioEntity usuario);
    void deleteById(Long id);
    Optional<UsuarioEntity> findByNombreAndRol(String nombre, Rol rol);
}
