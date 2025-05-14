package com.evalia.backEntrevistasInformes.Controller;

import com.evalia.backEntrevistasInformes.model.entrevista.EntrevistaFinalizadaDTO;
import com.evalia.backEntrevistasInformes.service.entrevistas.IEntrevistasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entrevistas")
public class EntrevistasController {

    @Autowired
    private IEntrevistasService entrevistaService;

    @PostMapping("/finalizar")
    public ResponseEntity<String> finalizarEntrevista(@RequestBody EntrevistaFinalizadaDTO dto) {
        String mensaje = entrevistaService.finalizarEntrevista(dto);
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("✅ Backend entrevistas operativo");
    }

}
