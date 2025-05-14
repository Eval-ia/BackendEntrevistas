package com.evalia.backEntrevistasInformes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.entity.RespuestaEntity;

public interface respuestaRepository extends JpaRepository<RespuestaEntity, Long> {

}
