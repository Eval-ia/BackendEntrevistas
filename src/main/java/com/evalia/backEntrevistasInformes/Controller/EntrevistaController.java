package com.evalia.backEntrevistasInformes.Controller;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;
import com.evalia.backEntrevistasInformes.service.survey.EntrevistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entrevistas")

public class EntrevistaController {

    @Autowired
    private EntrevistaService entrevistaService;

    @PostMapping("/crear")
    public ResponseEntity<EntrevistaEntity> crearEntrevista(@RequestBody EntrevistaEntity entrevista) {
        EntrevistaEntity creada = entrevistaService.crearEntrevista(entrevista);
        return ResponseEntity.ok(creada);
    }
}
