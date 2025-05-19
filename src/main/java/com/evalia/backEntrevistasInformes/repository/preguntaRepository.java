package com.evalia.backEntrevistasInformes.repository;

<<<<<<< HEAD
import java.util.Collection;
import java.util.List;
=======
>>>>>>> 089c16cd28ab5e5d6cb867a56df3b063b8bea4e0

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaEntity;
<<<<<<< HEAD
public interface PreguntaRepository extends JpaRepository<PreguntaEntity, Long> {
    List<PreguntaEntity> findByEsGenericaTrue();
    List<PreguntaEntity> findByPuesto_IdPuesto(Long idPuesto);
}
=======

public interface preguntaRepository extends JpaRepository<PreguntaEntity, Long> {

}
>>>>>>> 089c16cd28ab5e5d6cb867a56df3b063b8bea4e0
