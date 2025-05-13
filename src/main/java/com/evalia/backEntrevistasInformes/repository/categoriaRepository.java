package com.evalia.backEntrevistasInformes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;

public interface categoriaRepository extends JpaRepository<CategoriaEntity, Long>  {

}
