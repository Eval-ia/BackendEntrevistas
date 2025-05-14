package com.evalia.backEntrevistasInformes.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evalia.backEntrevistasInformes.repository.preguntaRepository;
import com.evalia.backEntrevistasInformes.repository.respuestaRepository;
import com.evalia.backEntrevistasInformes.service.survey.IPreguntaService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/preguntas")
@RequiredArgsConstructor
public class PreguntaController {


    private IPreguntaService preguntaService;

    @GetMapping
    public ResponseEntity<Map<String,List<String>>> obtenerPreguntas(@RequestParam String categoria, @RequestParam String nivel) {
        Map<String,List<String>> preguntas = preguntaService.obtenerPreguntasPorCategoriaYNivel(categoria, nivel);
        
        return ResponseEntity.ok(preguntas);
    }
    
    
}
