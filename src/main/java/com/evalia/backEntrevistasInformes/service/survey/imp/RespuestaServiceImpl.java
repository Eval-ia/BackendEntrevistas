package com.evalia.backEntrevistasInformes.service.survey.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;
import com.evalia.backEntrevistasInformes.model.entity.RespuestaEntity;
import com.evalia.backEntrevistasInformes.repository.entrevistaRepository;
import com.evalia.backEntrevistasInformes.repository.preguntaPersonalizadaRepository;
import com.evalia.backEntrevistasInformes.repository.preguntaRepository;
import com.evalia.backEntrevistasInformes.repository.respuestaRepository;
import com.evalia.backEntrevistasInformes.service.survey.RespuestaService;

@Service
public class RespuestaServiceImpl implements RespuestaService {

    @Autowired
    private respuestaRepository respuestaRepository;

    @Autowired
    private entrevistaRepository entrevistaRepository;

    @Autowired
    private preguntaRepository preguntaRepository;

    @Autowired
    private preguntaPersonalizadaRepository personalizadaRepository;

    @Override
    public void guardarRespuestas(List<RespuestaEntity> respuestas) {
        for (RespuestaEntity r : respuestas) {
            EntrevistaEntity entrevista = entrevistaRepository.findById(r.getEntrevista().getIdEntrevista())
                    .orElseThrow(() -> new RuntimeException("Entrevista no encontrada"));

            r.setEntrevista(entrevista);

            if (r.getPregunta() != null && r.getPregunta().getIdPregunta() != null) {
                r.setPregunta(preguntaRepository.findById(r.getPregunta().getIdPregunta())
                        .orElse(null));
            }

            if (r.getPreguntaPersonalizada() != null && r.getPreguntaPersonalizada().getIdPreguntaPersonalizada() != null) {
                r.setPreguntaPersonalizada(personalizadaRepository.findById(r.getPreguntaPersonalizada().getIdPreguntaPersonalizada())
                        .orElse(null));
            }

            respuestaRepository.save(r);
        }
    }
}
