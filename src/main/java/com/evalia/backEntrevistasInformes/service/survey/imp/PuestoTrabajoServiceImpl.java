package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;
import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;
import com.evalia.backEntrevistasInformes.model.entity.PuestoTrabajoEntity;
<<<<<<< HEAD
import com.evalia.backEntrevistasInformes.repository.CategoriaRepository;
import com.evalia.backEntrevistasInformes.repository.NivelRepository;
import com.evalia.backEntrevistasInformes.repository.PuestoTrabajoRepository;
=======
import com.evalia.backEntrevistasInformes.repository.categoriaRepository;
import com.evalia.backEntrevistasInformes.repository.nivelRepository;
import com.evalia.backEntrevistasInformes.repository.puestoTrabajoRepository;
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b
import com.evalia.backEntrevistasInformes.service.survey.PuestoTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PuestoTrabajoServiceImpl implements PuestoTrabajoService {

    @Autowired
<<<<<<< HEAD
    private PuestoTrabajoRepository puestoRepo;

    @Autowired
    private CategoriaRepository categoriaRepo;

    @Autowired
    private NivelRepository nivelRepo;
=======
    private puestoTrabajoRepository puestoRepo;

    @Autowired
    private categoriaRepository categoriaRepo;

    @Autowired
    private nivelRepository nivelRepo;
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b

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
