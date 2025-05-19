package com.evalia.backEntrevistasInformes.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evalia.backEntrevistasInformes.model.entity.PuestoTrabajoEntity;
import com.evalia.backEntrevistasInformes.service.survey.IPuestoTrabajoService;
import com.evalia.backEntrevistasInformes.service.survey.IUsuarioService;

@RestController
@RequestMapping("/api/puestos")
public class PuestosController {
    @Autowired
    private IPuestoTrabajoService puestoService;

    @GetMapping("/buscar")
    public ResponseEntity<PuestoTrabajoEntity> buscarPuestoPorCategoriaYNivel(
            @RequestParam String categoria,
            @RequestParam String nivel) {

        Optional<PuestoTrabajoEntity> puesto = puestoService.findByCategoriaNombreAndNivel(categoria, nivel);
        return puesto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}
