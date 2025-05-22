package com.evalia.backEntrevistasInformes.repository;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;
import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;
import com.evalia.backEntrevistasInformes.model.entity.PuestoTrabajoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

<<<<<<< HEAD
public interface PuestoTrabajoRepository extends JpaRepository<PuestoTrabajoEntity, Long> {
=======
public interface puestoTrabajoRepository extends JpaRepository<PuestoTrabajoEntity, Long> {
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b
    Optional<PuestoTrabajoEntity> findByCategoriaAndNivel(CategoriaEntity categoria, NivelEntity nivel);
}
