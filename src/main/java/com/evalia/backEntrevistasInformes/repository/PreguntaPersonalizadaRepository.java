package com.evalia.backEntrevistasInformes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaPersonalizadaEntity;

public interface PreguntaPersonalizadaRepository extends JpaRepository<PreguntaPersonalizadaEntity, Long>{
    //#region
    List<PreguntaPersonalizadaEntity> findByEntrevistaIdEntrevista(Long idEntrevista);

}
