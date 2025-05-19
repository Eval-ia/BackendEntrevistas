package com.evalia.backEntrevistasInformes.service.survey;

import com.evalia.backEntrevistasInformes.model.Rol;
import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;
import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    List<UsuarioEntity> findAll();
    Optional<UsuarioEntity> findById(Long id);
    UsuarioEntity save(UsuarioEntity usuario);
    void deleteById(Long id);
    Optional<UsuarioEntity> findByNombreAndRol(String nombre, Rol rol);

}
