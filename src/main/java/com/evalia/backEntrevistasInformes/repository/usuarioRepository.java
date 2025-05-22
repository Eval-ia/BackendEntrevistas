package com.evalia.backEntrevistasInformes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evalia.backEntrevistasInformes.model.Rol;
import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;

<<<<<<< HEAD:src/main/java/com/evalia/backEntrevistasInformes/repository/usuarioRepository.java
@Repository
<<<<<<< HEAD
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
=======
public interface usuarioRepository extends JpaRepository<UsuarioEntity, Long> {
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b

    List<UsuarioEntity> findByInformeIsNotNull();
    Optional<UsuarioEntity> findByNombreAndRol(String nombre, Rol rol);
=======
public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {
    List<UsuarioEntity> findByInformeIsNotNull();
    Optional<UsuarioEntity> findByNombreAndRol(String nombre, Rol rol);
    List<UsuarioEntity> findByIdUsuarioIn(List<Long> ids);
>>>>>>> ae34bfdbf3e4c946ab75e9d291395e5f68ab670a:src/main/java/com/evalia/backEntrevistasInformes/repository/UsuarioRepository.java
}
