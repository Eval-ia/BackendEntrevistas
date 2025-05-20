package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;
import com.evalia.backEntrevistasInformes.repository.EntrevistaRepository;
import com.evalia.backEntrevistasInformes.service.survey.IEntrevistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EntrevistaServiceImp implements IEntrevistaService {

    @Autowired
    private EntrevistaRepository entrevistaRepository;

    @Override
    public List<EntrevistaEntity> findAll() {
        return entrevistaRepository.findAll();
    }

    @Override
    public Optional<EntrevistaEntity> findById(Long id) {
        return entrevistaRepository.findById(id);
    }

    @Override
    public EntrevistaEntity save(EntrevistaEntity entrevista) {
        return entrevistaRepository.save(entrevista);
    }

    @Override
    public void deleteById(Long id) {
        entrevistaRepository.deleteById(id);
    }

    @Override
    public EntrevistaEntity crearEntrevista(EntrevistaEntity entrevista) {
        return entrevistaRepository.save(entrevista);
    }
}
