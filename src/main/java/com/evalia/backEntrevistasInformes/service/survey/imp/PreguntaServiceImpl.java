package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaEntity;
<<<<<<< HEAD
import com.evalia.backEntrevistasInformes.repository.PreguntaRepository;
=======
import com.evalia.backEntrevistasInformes.repository.preguntaRepository;
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b
import com.evalia.backEntrevistasInformes.service.survey.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    @Autowired
<<<<<<< HEAD
    private PreguntaRepository preguntaRepository;
=======
    private preguntaRepository preguntaRepository;
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b

    @Override
    public PreguntaEntity guardarPregunta(PreguntaEntity pregunta) {
        return preguntaRepository.save(pregunta);
    }

     @Override
    public List<PreguntaEntity> obtenerPorPuesto(Long idPuesto) {
        return preguntaRepository.findByPuesto_IdPuesto(idPuesto);
    }

     @Override
    public List<PreguntaEntity> obtenerGenericas() {
        return preguntaRepository.findByEsGenericaTrue();
    }
}
