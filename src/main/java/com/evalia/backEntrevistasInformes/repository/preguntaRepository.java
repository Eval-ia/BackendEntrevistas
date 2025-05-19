package com.evalia.backEntrevistasInformes.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaEntity;
public interface PreguntaRepository extends JpaRepository<PreguntaEntity, Long> {

    Collection<PreguntaEntity> findByPuesto_CategoriaAndPuesto_NivelAndEsGenerica(String categoria, String nivel,
            boolean b);


}
