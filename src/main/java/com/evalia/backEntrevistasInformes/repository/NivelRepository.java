package com.evalia.backEntrevistasInformes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;

public interface NivelRepository extends JpaRepository<NivelEntity, Long> {
    //#region
        Optional<NivelEntity> findByNombreIgnoreCase(String nombre);

}
