package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;
import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;
import com.evalia.backEntrevistasInformes.model.entity.PuestoTrabajoEntity;
import com.evalia.backEntrevistasInformes.repository.categoriaRepository;
import com.evalia.backEntrevistasInformes.repository.nivelRepository;
import com.evalia.backEntrevistasInformes.repository.puestoTrabajoRepository;
import com.evalia.backEntrevistasInformes.service.survey.PuestoTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PuestoTrabajoServiceImpl implements PuestoTrabajoService {

    @Autowired
    private puestoTrabajoRepository puestoRepo;

    @Autowired
    private categoriaRepository categoriaRepo;

    @Autowired
    private nivelRepository nivelRepo;

    @Override
    public PuestoTrabajoEntity crearOPreexistente(String tecnologia, String nivel) {
        CategoriaEntity categoria = categoriaRepo.findByNombreIgnoreCase(tecnologia)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        NivelEntity nivelEntity = nivelRepo.findByNombreIgnoreCase(nivel)
                .orElseThrow(() -> new RuntimeException("Nivel no encontrado"));

        return puestoRepo.findByCategoriaAndNivel(categoria, nivelEntity)
                .orElseGet(() -> {
                    PuestoTrabajoEntity nuevo = new PuestoTrabajoEntity();
                    nuevo.setCategoria(categoria);
                    nuevo.setNivel(nivelEntity);
                    nuevo.setNombre("");
                    nuevo.setDescripcion("");
                    return puestoRepo.save(nuevo);
                });
    }
}
