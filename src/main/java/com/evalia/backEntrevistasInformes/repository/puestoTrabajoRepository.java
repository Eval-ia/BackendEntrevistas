package com.evalia.backEntrevistasInformes.repository;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;
import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;
import com.evalia.backEntrevistasInformes.model.entity.PuestoTrabajoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PuestoTrabajoRepository extends JpaRepository<PuestoTrabajoEntity, Long> {
    Optional<PuestoTrabajoEntity> findByCategoriaAndNivel(CategoriaEntity categoria, NivelEntity nivel);
}
