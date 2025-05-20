package com.evalia.backEntrevistasInformes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;

public interface NivelRepository extends JpaRepository<NivelEntity, Long> {
    //#region
<<<<<<< HEAD
        Optional<NivelEntity> findByNombreIgnoreCase(String nombre);

=======
    Optional<NivelEntity> findByNombre(String nombre);
>>>>>>> 4413ea7911a7adeb80658fc4926f73d67eba1df2
}
