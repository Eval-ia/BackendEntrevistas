package com.evalia.backEntrevistasInformes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;

public interface EntrevistaRepository extends JpaRepository<EntrevistaEntity, Long> {
    @Query("SELECT e FROM Entrevistas e " +
            "LEFT JOIN FETCH e.candidato " +
            "LEFT JOIN FETCH e.entrevistador " +
            "LEFT JOIN FETCH e.puesto " +
            "WHERE e.idEntrevista = :id")
    EntrevistaEntity cargarEntrevistaCompleta(@Param("id") Long id);

    EntrevistaEntity findFirstByCandidatoIdUsuario(Long idUsuario);
}

