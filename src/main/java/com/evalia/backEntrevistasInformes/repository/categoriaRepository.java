package com.evalia.backEntrevistasInformes.repository;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

    Optional<CategoriaEntity> findByNombreIgnoreCase(String nombre);
}
