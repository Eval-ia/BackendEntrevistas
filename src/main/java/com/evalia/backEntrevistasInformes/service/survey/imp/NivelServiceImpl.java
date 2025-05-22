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
    public NivelEntity guardarNivel(String nombre) {
        return nivelRepository.findByNombreIgnoreCase(nombre)
                .orElseGet(() -> {
                    NivelEntity nuevo = new NivelEntity();
                    nuevo.setNombre(nombre);
                    return nivelRepository.save(nuevo);
                });
    }
}
