package com.evalia.backEntrevistasInformes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaEntity;

public interface PreguntaRepository extends JpaRepository<PreguntaEntity, Long> {
    List<PreguntaEntity> findByEsGenericaTrue();
    List<PreguntaEntity> findByPuesto_IdPuesto(Long idPuesto);
}
