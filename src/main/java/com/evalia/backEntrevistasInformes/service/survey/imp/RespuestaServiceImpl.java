package com.evalia.backEntrevistasInformes.service.survey.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;
import com.evalia.backEntrevistasInformes.model.entity.RespuestaEntity;
<<<<<<< HEAD
import com.evalia.backEntrevistasInformes.repository.EntrevistaRepository;
import com.evalia.backEntrevistasInformes.repository.PreguntaPersonalizadaRepository;
import com.evalia.backEntrevistasInformes.repository.PreguntaRepository;
import com.evalia.backEntrevistasInformes.repository.RespuestaRepository;
=======
import com.evalia.backEntrevistasInformes.repository.entrevistaRepository;
import com.evalia.backEntrevistasInformes.repository.preguntaPersonalizadaRepository;
import com.evalia.backEntrevistasInformes.repository.preguntaRepository;
import com.evalia.backEntrevistasInformes.repository.respuestaRepository;
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b
import com.evalia.backEntrevistasInformes.service.survey.RespuestaService;

@Service
public class RespuestaServiceImpl implements RespuestaService {

    @Autowired
<<<<<<< HEAD
    private RespuestaRepository respuestaRepository;

    @Autowired
    private EntrevistaRepository entrevistaRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private PreguntaPersonalizadaRepository personalizadaRepository;
=======
    private respuestaRepository respuestaRepository;

    @Autowired
    private entrevistaRepository entrevistaRepository;

    @Autowired
    private preguntaRepository preguntaRepository;

    @Autowired
    private preguntaPersonalizadaRepository personalizadaRepository;
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b

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
