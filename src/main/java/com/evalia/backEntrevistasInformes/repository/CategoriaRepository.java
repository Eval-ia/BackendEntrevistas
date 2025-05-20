package com.evalia.backEntrevistasInformes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
    Optional<CategoriaEntity> findByNombre(String nombre);
    Optional<CategoriaEntity> findByNombreIgnoreCase(String nombre);

}
