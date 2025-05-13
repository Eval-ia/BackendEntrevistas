package com.evalia.backEntrevistasInformes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;

public interface usuarioRepository extends JpaRepository<UsuarioEntity,Long> {

}
