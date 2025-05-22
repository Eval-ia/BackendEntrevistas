package com.evalia.backEntrevistasInformes.Controller;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;
import com.evalia.backEntrevistasInformes.model.entrevista.EntrevistaFinalizadaDTO;
import com.evalia.backEntrevistasInformes.service.survey.EntrevistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entrevistas")

public class EntrevistaController {

    @Autowired
    private EntrevistaService entrevistaService;

     @PostMapping("/finalizar")
    public ResponseEntity<String> finalizarEntrevista(@RequestBody EntrevistaFinalizadaDTO dto) {
         System.out.println("Finalizando entrevista...");
        String mensaje = entrevistaService.finalizarEntrevista(dto);
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("✅ Backend entrevistas operativo");
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<?>> getCategorias() {

        return ResponseEntity.ok(
                List.of(CategoriaTecnologiaService.getAllCategoriasTecnologias()));

    }
}
