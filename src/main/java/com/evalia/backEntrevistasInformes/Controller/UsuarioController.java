package com.evalia.backEntrevistasInformes.Controller;

import com.evalia.backEntrevistasInformes.model.Rol;
import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;
import com.evalia.backEntrevistasInformes.service.survey.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    
    @PostMapping("/crear")
    public ResponseEntity<List<UsuarioEntity>> crearUsuarios(@RequestParam String entrevistador, @RequestParam String candidato) {
        UsuarioEntity ent = usuarioService.crearUsuario(entrevistador, Rol.ENTREVISTADOR);
        UsuarioEntity cand = usuarioService.crearUsuario(candidato, Rol.CANDIDATO);
        return ResponseEntity.ok(List.of(ent, cand));
    }
}
