package com.evalia.backEntrevistasInformes.repository;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaPersonalizadaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreguntaPersonalizadaRepository extends JpaRepository<PreguntaPersonalizadaEntity, Long> {

    List<PreguntaPersonalizadaEntity> findByEntrevistaIdEntrevista(Long idEntrevista);
}
