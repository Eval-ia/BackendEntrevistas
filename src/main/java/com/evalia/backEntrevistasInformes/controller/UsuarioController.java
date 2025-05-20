package com.evalia.backEntrevistasInformes.Controller;

// public package com.evalia.backEntrevistasInformes.controller;

import com.evalia.backEntrevistasInformes.model.Rol;
import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;
import com.evalia.backEntrevistasInformes.service.survey.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/buscar")
    public ResponseEntity<UsuarioEntity> buscarUsuarioPorNombreYRol(
            @RequestParam String nombre,
            @RequestParam Rol rol) {

        Optional<UsuarioEntity> usuario = usuarioService.findByNombreAndRol(nombre, rol);
        return usuario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<UsuarioEntity> crearUsuario(@RequestBody UsuarioEntity nuevoUsuario) {
        UsuarioEntity creado = usuarioService.save(nuevoUsuario);
        return ResponseEntity.ok(creado);
    }
}
