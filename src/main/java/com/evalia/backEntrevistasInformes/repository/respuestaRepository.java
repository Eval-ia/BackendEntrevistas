package com.evalia.backEntrevistasInformes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.entity.RespuestaEntity;

public interface respuestaRepository extends JpaRepository<RespuestaEntity, Long> {
    List<RespuestaEntity> findByEntrevistaIdEntrevista(Long idEntrevista);
}
