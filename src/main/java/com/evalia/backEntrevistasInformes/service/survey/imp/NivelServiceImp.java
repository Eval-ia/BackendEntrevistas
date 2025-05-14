package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;
import com.evalia.backEntrevistasInformes.repository.nivelRepository;
import com.evalia.backEntrevistasInformes.service.survey.INivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NivelServiceImp implements INivelService {
    
    @Autowired
    private nivelRepository nivelRepository;

    @Override
    public List<NivelEntity> findAll() {
        return nivelRepository.findAll();
    }

    @Override
    public Optional<NivelEntity> findById(Long id) {
        return nivelRepository.findById(id);
    }

    @Override
    public NivelEntity save(NivelEntity nivel) {
        return nivelRepository.save(nivel);
    }

    @Override
    public void deleteById(Long id) {
        nivelRepository.deleteById(id);
    }
}
