package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.Rol;
import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;
<<<<<<< HEAD
import com.evalia.backEntrevistasInformes.repository.UsuarioRepository;
=======
import com.evalia.backEntrevistasInformes.repository.usuarioRepository;
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b
import com.evalia.backEntrevistasInformes.service.survey.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioEntity crearUsuario(String nombre, Rol rol) {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNombre(nombre);
        usuario.setRol(rol);
        return usuarioRepository.save(usuario);
    }

        @Override
    public List<UsuarioEntity> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<UsuarioEntity> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public UsuarioEntity save(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Optional<UsuarioEntity> findByNombreAndRol(String nombre, Rol rol) {
        return usuarioRepository.findByNombreAndRol(nombre, rol);
    }
<<<<<<< HEAD
=======

    @Override
    public List<UsuarioEntity> buscarPorIds(List<Long> ids) {
        return usuarioRepository.findByIdUsuarioIn(ids);
    }

>>>>>>> ae34bfdbf3e4c946ab75e9d291395e5f68ab670a
}
