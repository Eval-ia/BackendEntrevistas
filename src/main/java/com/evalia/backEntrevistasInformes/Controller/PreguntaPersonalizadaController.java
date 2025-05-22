package com.evalia.backEntrevistasInformes.Controller;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaPersonalizadaEntity;
import com.evalia.backEntrevistasInformes.service.survey.PreguntaPersonalizadaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preguntas/personalizada")
public class PreguntaPersonalizadaController {

    @Autowired
    private PreguntaPersonalizadaService personalizadaService;

    @PostMapping
    public ResponseEntity<PreguntaPersonalizadaEntity> guardar(@RequestBody PreguntaPersonalizadaRequest request) {
        PreguntaPersonalizadaEntity pregunta = personalizadaService.guardar(request.getTexto(), request.getEntrevistaId());
        return ResponseEntity.ok(pregunta);
    }

    @GetMapping("/{idEntrevista}")
    public ResponseEntity<List<PreguntaPersonalizadaEntity>> listar(@PathVariable Long idEntrevista) {
        return ResponseEntity.ok(personalizadaService.listarPorEntrevista(idEntrevista));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        personalizadaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @Data
    public static class PreguntaPersonalizadaRequest {
        private String texto;
        private Long entrevistaId;
    }
}
