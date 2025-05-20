package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;
import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;
import com.evalia.backEntrevistasInformes.model.entity.PuestoTrabajoEntity;
import com.evalia.backEntrevistasInformes.repository.PuestoTrabajoRepository;
import com.evalia.backEntrevistasInformes.service.survey.IPuestoTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PuestoTrabajoServiceImp implements IPuestoTrabajoService {
    
    @Autowired
    private PuestoTrabajoRepository puestoTrabajoRepository;

    @Override
    public List<PuestoTrabajoEntity> findAll() {
        return puestoTrabajoRepository.findAll();
    }

    @Override
    public Optional<PuestoTrabajoEntity> findById(Long id) {
        return puestoTrabajoRepository.findById(id);
    }

    @Override
    public PuestoTrabajoEntity save(PuestoTrabajoEntity puestoTrabajo) {
        return puestoTrabajoRepository.save(puestoTrabajo);
    }

    @Override
    public void deleteById(Long id) {
        puestoTrabajoRepository.deleteById(id);
    }

    @Override
    public PuestoTrabajoEntity crearOPreexistente(String tecnologia, String nivel) {
        CategoriaEntity categoria = categoriaRepository.findByNombreIgnoreCase(tecnologia)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        NivelEntity nivelEntity = nivelRepository.findByNombreIgnoreCase(nivel)
                .orElseThrow(() -> new RuntimeException("Nivel no encontrado"));

        return puestoTrabajoRepository.findByCategoriaAndNivel(categoria, nivelEntity)
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
