package com.evalia.backEntrevistasInformes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.Rol;
import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {
    List<UsuarioEntity> findByInformeIsNotNull();
    Optional<UsuarioEntity> findByNombreAndRol(String nombre, Rol rol);
    
}
