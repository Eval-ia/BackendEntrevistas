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
<<<<<<< HEAD
@CrossOrigin(origins = "http://localhost:5173")
=======
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarRespuestas(@RequestBody List<RespuestaEntity> respuestas) {
        respuestaService.guardarRespuestas(respuestas);
        return ResponseEntity.ok("Respuestas guardadas correctamente");
    }
}
