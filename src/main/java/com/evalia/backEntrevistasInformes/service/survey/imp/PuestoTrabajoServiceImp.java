package com.evalia.backEntrevistasInformes.service.survey.imp;

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
}
