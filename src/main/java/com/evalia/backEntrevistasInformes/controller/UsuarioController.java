package com.evalia.backEntrevistasInformes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// public package com.evalia.backEntrevistasInformes.controller;

import com.evalia.backEntrevistasInformes.model.Rol;
import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;
import com.evalia.backEntrevistasInformes.service.survey.IUsuarioService;

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

    @PostMapping("/candidatos")
    public ResponseEntity<List<UsuarioEntity>> obtenerUsuariosPorIds(@RequestBody List<Long> ids) {
        List<UsuarioEntity> usuarios = usuarioService.buscarCandidatosPorIds(ids);
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/crear")
    public ResponseEntity<UsuarioEntity> crearUsuario(@RequestBody UsuarioEntity nuevoUsuario) {
        UsuarioEntity creado = usuarioService.save(nuevoUsuario);
        return ResponseEntity.ok(creado);
    }
}
