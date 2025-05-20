package com.evalia.backEntrevistasInformes.Controller;

import com.evalia.backEntrevistasInformes.model.entity.PuestoTrabajoEntity;
import com.evalia.backEntrevistasInformes.service.survey.PuestoTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/puestos")
@CrossOrigin(origins = "http://localhost:5173")
public class PuestoTrabajoController {

    @Autowired
    private PuestoTrabajoService puestoTrabajoService;

    @PostMapping("/crear-o-buscar")
    public Long crearOPuesto(@RequestBody PuestoFiltro filtro) {
        PuestoTrabajoEntity puesto = puestoTrabajoService.crearOPreexistente(filtro.getTecnologia(), filtro.getNivel());
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
