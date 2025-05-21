package com.evalia.backEntrevistasInformes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evalia.backEntrevistasInformes.model.entity.RespuestaEntity;
import com.evalia.backEntrevistasInformes.service.survey.RespuestaService;

@RestController
@RequestMapping("/api/respuestas")
@CrossOrigin(origins = "http://localhost:5173")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarRespuestas(@RequestBody List<RespuestaEntity> respuestas) {
        respuestaService.guardarRespuestas(respuestas);
        return ResponseEntity.ok("Respuestas guardadas correctamente");
    }
}
