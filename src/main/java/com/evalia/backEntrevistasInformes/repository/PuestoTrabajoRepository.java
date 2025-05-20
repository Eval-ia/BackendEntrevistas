package com.evalia.backEntrevistasInformes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;
import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;
import com.evalia.backEntrevistasInformes.model.entity.PuestoTrabajoEntity;

public interface PuestoTrabajoRepository extends JpaRepository<PuestoTrabajoEntity, Long>{
    //#region
        Optional<PuestoTrabajoEntity> findByCategoriaAndNivel(CategoriaEntity categoria, NivelEntity nivel);

}
