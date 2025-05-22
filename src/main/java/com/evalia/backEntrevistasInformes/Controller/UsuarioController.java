<<<<<<< HEAD:src/main/java/com/evalia/backEntrevistasInformes/Controller/UsuarioController.java
package com.evalia.backEntrevistasInformes.Controller;

import com.evalia.backEntrevistasInformes.model.Rol;
import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;
import com.evalia.backEntrevistasInformes.service.survey.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
=======
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
>>>>>>> ae34bfdbf3e4c946ab75e9d291395e5f68ab670a:src/main/java/com/evalia/backEntrevistasInformes/controller/UsuarioController.java

@RestController
@RequestMapping("/api/usuarios")
<<<<<<< HEAD
@CrossOrigin(origins = "http://localhost:5173")
=======
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


        @GetMapping("/buscar")
    public ResponseEntity<UsuarioEntity> buscarUsuarioPorNombreYRol(
            @RequestParam String nombre,
            @RequestParam Rol rol) {

        Optional<UsuarioEntity> usuario = usuarioService.findByNombreAndRol(nombre, rol);
        return usuario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
<<<<<<< HEAD:src/main/java/com/evalia/backEntrevistasInformes/Controller/UsuarioController.java
    
=======

    @PostMapping("/candidatos")
    public ResponseEntity<List<UsuarioEntity>> obtenerUsuariosPorIds(@RequestBody List<Long> ids) {
        List<UsuarioEntity> usuarios = usuarioService.buscarPorIds(ids);
        return ResponseEntity.ok(usuarios);
    }

>>>>>>> ae34bfdbf3e4c946ab75e9d291395e5f68ab670a:src/main/java/com/evalia/backEntrevistasInformes/controller/UsuarioController.java
    @PostMapping("/crear")
    public ResponseEntity<List<UsuarioEntity>> crearUsuarios(@RequestParam String entrevistador, @RequestParam String candidato) {
        UsuarioEntity ent = usuarioService.crearUsuario(entrevistador, Rol.ENTREVISTADOR);
        UsuarioEntity cand = usuarioService.crearUsuario(candidato, Rol.CANDIDATO);
        return ResponseEntity.ok(List.of(ent, cand));
    }
}
