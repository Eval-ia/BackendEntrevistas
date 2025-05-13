package com.evalia.backEntrevistasInformes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;

public interface entrevistaRepository extends JpaRepository<EntrevistaEntity,Long> {

}
