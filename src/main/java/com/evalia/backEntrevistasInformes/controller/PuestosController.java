package com.evalia.backEntrevistasInformes.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evalia.backEntrevistasInformes.model.entity.PuestoTrabajoEntity;
import com.evalia.backEntrevistasInformes.service.survey.IPuestoTrabajoService;

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

    @PostMapping("/crear-o-buscar")
    public Long crearOPuesto(@RequestBody PuestoFiltro filtro) {
        PuestoTrabajoEntity puesto = puestoService.crearOPreexistente(filtro.getTecnologia(), filtro.getNivel());
        return puesto.getIdPuesto();
    }

    public static class PuestoFiltro {
        private String tecnologia;
        private String nivel;

        public String getTecnologia() {
            return tecnologia;
        }

        public void setTecnologia(String tecnologia) {
            this.tecnologia = tecnologia;
        }

        public String getNivel() {
            return nivel;
        }

        public void setNivel(String nivel) {
            this.nivel = nivel;
        }
    }

}
