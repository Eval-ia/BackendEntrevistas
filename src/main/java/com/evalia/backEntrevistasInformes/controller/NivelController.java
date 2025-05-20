package com.evalia.backEntrevistasInformes.controller;

import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;
import com.evalia.backEntrevistasInformes.service.survey.INivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nivel")
public class NivelController {

    @Autowired
    private INivelService nivelService;

    @PostMapping("/guardar")
    public NivelEntity guardarNivel(@RequestParam String nombre) {
        return nivelService.guardarNivel(nombre);
    }
}
