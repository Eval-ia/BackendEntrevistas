package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaEntity;
import com.evalia.backEntrevistasInformes.repository.preguntaRepository;
import com.evalia.backEntrevistasInformes.service.survey.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    @Autowired
    private preguntaRepository preguntaRepository;

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
