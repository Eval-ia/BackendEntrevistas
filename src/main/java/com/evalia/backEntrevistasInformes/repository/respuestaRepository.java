package com.evalia.backEntrevistasInformes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.entity.RespuestaEntity;

<<<<<<< HEAD
public interface RespuestaRepository extends JpaRepository<RespuestaEntity, Long> {
=======
public interface respuestaRepository extends JpaRepository<RespuestaEntity, Long> {
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b
    List<RespuestaEntity> findByEntrevistaIdEntrevista(Long idEntrevista);
}
