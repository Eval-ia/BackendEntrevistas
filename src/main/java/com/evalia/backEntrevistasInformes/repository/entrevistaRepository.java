package com.evalia.backEntrevistasInformes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;

public interface entrevistaRepository extends JpaRepository<EntrevistaEntity, Long> {
@Query("SELECT e FROM EntrevistaEntity e " +
       "LEFT JOIN FETCH e.candidato " +
       "LEFT JOIN FETCH e.entrevistador " +
       "LEFT JOIN FETCH e.puesto " +
       "WHERE e.idEntrevista = :idEntrevista")
EntrevistaEntity cargarEntrevistaCompleta(@Param("idEntrevista") Long idEntrevista);
}
