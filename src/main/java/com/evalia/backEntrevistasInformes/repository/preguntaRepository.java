package com.evalia.backEntrevistasInformes.repository;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface preguntaRepository extends JpaRepository<PreguntaEntity, Long> {
    List<PreguntaEntity> findByEsGenericaTrue();
    List<PreguntaEntity> findByPuesto_IdPuesto(Long idPuesto);
}
