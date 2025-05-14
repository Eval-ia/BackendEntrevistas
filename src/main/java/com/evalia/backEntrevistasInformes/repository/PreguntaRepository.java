package com.evalia.backEntrevistasInformes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaEntity;

<<<<<<< HEAD:src/main/java/com/evalia/backEntrevistasInformes/repository/preguntaRepository.java
public interface preguntaRepository extends JpaRepository<PreguntaEntity, Long> {

    List<PreguntaEntity> findByPuesto_CategoriaAndPuesto_NivelAndEsGenerica(String categoria, String nivel, Boolean esGenerica);
=======
public interface PreguntaRepository extends JpaRepository<PreguntaEntity, Long> {
    //#region
>>>>>>> main:src/main/java/com/evalia/backEntrevistasInformes/repository/PreguntaRepository.java
}
