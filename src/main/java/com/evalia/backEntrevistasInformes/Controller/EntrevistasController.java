package com.evalia.backEntrevistasInformes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evalia.backEntrevistasInformes.model.entrevista.EntrevistaFinalizadaDTO;
import com.evalia.backEntrevistasInformes.service.entrevistas.IEntrevistasService;
import com.evalia.backEntrevistasInformes.service.survey.ICategoriaService;
import com.evalia.backEntrevistasInformes.service.survey.ICategoriaTecnologiaService;

@RestController
@RequestMapping("/api/entrevistas")
public class EntrevistasController {

    @Autowired
    private IEntrevistasService entrevistaService;

    @Autowired
    private ICategoriaService categoriaService;

    @Autowired
    private ICategoriaTecnologiaService categoriaTecnologiaService;

    @PostMapping("/finalizar")
    public ResponseEntity<String> finalizarEntrevista(@RequestBody EntrevistaFinalizadaDTO dto) {
        String mensaje = entrevistaService.finalizarEntrevista(dto);
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("✅ Backend entrevistas operativo");
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<?>> getCategorias() {
        return ResponseEntity.ok(categoriaTecnologiaService.getAllCategoriasTecnologias());
    }

}
