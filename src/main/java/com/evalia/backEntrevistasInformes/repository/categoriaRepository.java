package com.evalia.backEntrevistasInformes.repository;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
=======
public interface categoriaRepository extends JpaRepository<CategoriaEntity, Long> {
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b
    Optional<CategoriaEntity> findByNombreIgnoreCase(String nombre);
}
