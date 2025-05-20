package com.evalia.backEntrevistasInformes.controller;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;
import com.evalia.backEntrevistasInformes.service.survey.ICategoriaTecnologiaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private ICategoriaTecnologiaService categoriaService;

    
}
