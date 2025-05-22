package com.evalia.backEntrevistasInformes.Controller;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaEntity;
import com.evalia.backEntrevistasInformes.service.survey.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @PostMapping("/guardar")
    public ResponseEntity<PreguntaEntity> guardarPregunta(@RequestBody PreguntaEntity pregunta) {
        return ResponseEntity.ok(preguntaService.guardarPregunta(pregunta));
    }

    @GetMapping("/puesto/{idPuesto}")
    public ResponseEntity<List<PreguntaEntity>> obtenerPorPuesto(@PathVariable Long idPuesto) {
        return ResponseEntity.ok(preguntaService.obtenerPorPuesto(idPuesto));
    }

    @GetMapping("/genericas")
    public ResponseEntity<List<PreguntaEntity>> obtenerGenericas() {
        return ResponseEntity.ok(preguntaService.obtenerGenericas());
    }
}
