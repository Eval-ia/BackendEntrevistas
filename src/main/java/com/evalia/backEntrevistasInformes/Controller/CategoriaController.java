package com.evalia.backEntrevistasInformes.Controller;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;
import com.evalia.backEntrevistasInformes.service.survey.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categoria")
<<<<<<< HEAD
@CrossOrigin(origins = "http://localhost:5173")
=======
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/guardar")
    public CategoriaEntity guardarCategoria(@RequestParam String nombre) {
        return categoriaService.guardarCategoria(nombre);
    }
}
