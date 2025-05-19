package com.evalia.backEntrevistasInformes.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaEntity;
import com.evalia.backEntrevistasInformes.repository.PreguntaRepository;
import com.evalia.backEntrevistasInformes.repository.RespuestaRepository;
import com.evalia.backEntrevistasInformes.service.survey.IPreguntaService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/preguntas")
@RequiredArgsConstructor
public class PreguntaController {


    private IPreguntaService preguntaService;

        @GetMapping("/puesto/{idPuesto}")
    public ResponseEntity<List<PreguntaEntity>> obtenerPorPuesto(@PathVariable Long idPuesto) {
        return ResponseEntity.ok(preguntaService.obtenerPorPuesto(idPuesto));
    }

    @GetMapping("/genericas")
    public ResponseEntity<List<PreguntaEntity>> obtenerGenericas() {
        return ResponseEntity.ok(preguntaService.obtenerGenericas());
    }

    // @GetMapping
    // public ResponseEntity<Map<String,List<String>>> obtenerPreguntas(@RequestParam String categoria, @RequestParam String nivel) {
    //     Map<String,List<String>> preguntas = preguntaService.obtenerPreguntasPorCategoriaYNivel(categoria, nivel);
    //     return ResponseEntity.ok(preguntas);
    // }
    
    
}
