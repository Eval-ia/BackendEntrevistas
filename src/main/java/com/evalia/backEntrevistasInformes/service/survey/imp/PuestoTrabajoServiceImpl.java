package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;
import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;
import com.evalia.backEntrevistasInformes.model.entity.PuestoTrabajoEntity;
import com.evalia.backEntrevistasInformes.repository.CategoriaRepository;
import com.evalia.backEntrevistasInformes.repository.NivelRepository;
import com.evalia.backEntrevistasInformes.repository.PuestoTrabajoRepository;
import com.evalia.backEntrevistasInformes.service.survey.PuestoTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PuestoTrabajoServiceImpl implements PuestoTrabajoService {

    @Autowired
    private PuestoTrabajoRepository puestoRepo;

    @Autowired
    private CategoriaRepository categoriaRepo;

    @Autowired
    private NivelRepository nivelRepo;

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
