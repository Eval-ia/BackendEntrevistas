package com.evalia.backEntrevistasInformes.repository;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface entrevistaRepository extends JpaRepository<EntrevistaEntity, Long> {
}
