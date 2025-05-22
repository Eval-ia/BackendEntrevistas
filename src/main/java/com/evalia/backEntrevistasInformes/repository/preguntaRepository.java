package com.evalia.backEntrevistasInformes.repository;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

<<<<<<< HEAD
public interface PreguntaRepository extends JpaRepository<PreguntaEntity, Long> {
=======
public interface preguntaRepository extends JpaRepository<PreguntaEntity, Long> {
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b
    List<PreguntaEntity> findByEsGenericaTrue();
    List<PreguntaEntity> findByPuesto_IdPuesto(Long idPuesto);
}
