package com.evalia.backEntrevistasInformes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evalia.backEntrevistasInformes.model.Rol;
import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;

@Repository
public interface usuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    List<UsuarioEntity> findByInformeIsNotNull();
    Optional<UsuarioEntity> findByNombreAndRol(String nombre, Rol rol);
}
