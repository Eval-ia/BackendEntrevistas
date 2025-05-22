package com.evalia.backEntrevistasInformes.repository;

import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
public interface NivelRepository extends JpaRepository<NivelEntity, Long> {
=======
public interface nivelRepository extends JpaRepository<NivelEntity, Long> {
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b
    Optional<NivelEntity> findByNombreIgnoreCase(String nombre);
}
