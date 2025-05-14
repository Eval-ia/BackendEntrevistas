package com.evalia.backEntrevistasInformes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaEntity;

public interface preguntaRepository extends JpaRepository<PreguntaEntity, Long> {

}
