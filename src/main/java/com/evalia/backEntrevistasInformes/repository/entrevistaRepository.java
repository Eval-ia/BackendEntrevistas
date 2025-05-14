package com.evalia.backEntrevistasInformes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;

public interface EntrevistaRepository extends JpaRepository<EntrevistaEntity, Long> {
    @Query("SELECT e FROM Entrevista e " +
            "LEFT JOIN FETCH e.entrevistado " +
            "LEFT JOIN FETCH e.entrevistador " +
            "LEFT JOIN FETCH e.puesto " +
            "LEFT JOIN FETCH e.preguntasPersonalizadas " +
            "LEFT JOIN FETCH e.respuestas " +
            "WHERE e.id = :id")
    EntrevistaEntity cargarEntrevistaCompleta(@Param("id") Long id);
}
