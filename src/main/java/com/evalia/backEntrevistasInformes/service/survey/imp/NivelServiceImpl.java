package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;

import com.evalia.backEntrevistasInformes.repository.NivelRepository;

import com.evalia.backEntrevistasInformes.service.survey.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NivelServiceImpl implements NivelService {

    @Autowired
    private NivelRepository nivelRepository;

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
    @Override
    public NivelEntity guardarNivel(String nombre) {
        return nivelRepository.findByNombreIgnoreCase(nombre)
                .orElseGet(() -> {
                    NivelEntity nuevo = new NivelEntity();
                    nuevo.setNombre(nombre);
                    return nivelRepository.save(nuevo);
                });
    }
}
