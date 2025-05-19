package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;
import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;
import com.evalia.backEntrevistasInformes.model.entity.PuestoTrabajoEntity;
import com.evalia.backEntrevistasInformes.repository.CategoriaRepository;
import com.evalia.backEntrevistasInformes.repository.NivelRepository;
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
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private NivelRepository nivelRepository;

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
    public Optional<PuestoTrabajoEntity> findByCategoriaNombreAndNivel(String nombreCategoria, String nombreNivel) {
    Optional<CategoriaEntity> categoriaOpt = categoriaRepository.findByNombre(nombreCategoria);
    Optional<NivelEntity> nivelOpt = nivelRepository.findByNombre(nombreNivel);
    if (categoriaOpt.isEmpty() || nivelOpt.isEmpty()) return Optional.empty();
    return puestoTrabajoRepository.findByCategoriaAndNivel(categoriaOpt.get(), nivelOpt.get());
}


   

}
