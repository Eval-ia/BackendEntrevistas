package com.evalia.backEntrevistasInformes.Controller;

import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;
import com.evalia.backEntrevistasInformes.service.survey.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nivel")
public class NivelController {

    @Autowired
    private NivelService nivelService;

    @PostMapping("/guardar")
    public NivelEntity guardarNivel(@RequestParam String nombre) {
        return nivelService.guardarNivel(nombre);
    }
}
