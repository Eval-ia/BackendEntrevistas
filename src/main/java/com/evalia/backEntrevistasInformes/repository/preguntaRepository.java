package com.evalia.backEntrevistasInformes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaEntity;

public interface preguntaRepository extends JpaRepository<PreguntaEntity, Long> {

    List<PreguntaEntity> findByPuesto_CategoriaAndPuesto_NivelAndEsGenerica(String categoria, String nivel, Boolean esGenerica);
}
