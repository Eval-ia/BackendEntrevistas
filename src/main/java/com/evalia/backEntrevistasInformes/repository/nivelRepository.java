package com.evalia.backEntrevistasInformes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;

public interface nivelRepository extends JpaRepository<NivelEntity, Long> {

}
