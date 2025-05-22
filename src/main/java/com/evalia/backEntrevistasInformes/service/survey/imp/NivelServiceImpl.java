package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;
<<<<<<< HEAD
import com.evalia.backEntrevistasInformes.repository.NivelRepository;
=======
import com.evalia.backEntrevistasInformes.repository.nivelRepository;
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b
import com.evalia.backEntrevistasInformes.service.survey.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NivelServiceImpl implements NivelService {

    @Autowired
<<<<<<< HEAD
    private NivelRepository nivelRepository;
=======
    private nivelRepository nivelRepository;
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b

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
