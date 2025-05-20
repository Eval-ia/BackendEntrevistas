package com.evalia.backEntrevistasInformes.repository;

import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface nivelRepository extends JpaRepository<NivelEntity, Long> {
    Optional<NivelEntity> findByNombreIgnoreCase(String nombre);
}
