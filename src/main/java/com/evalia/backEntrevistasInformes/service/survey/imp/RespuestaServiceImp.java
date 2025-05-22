package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;
import com.evalia.backEntrevistasInformes.model.entity.RespuestaEntity;
import com.evalia.backEntrevistasInformes.model.respuesta.RespuestaDTO;
import com.evalia.backEntrevistasInformes.repository.EntrevistaRepository;
import com.evalia.backEntrevistasInformes.repository.PreguntaPersonalizadaRepository;
import com.evalia.backEntrevistasInformes.repository.PreguntaRepository;
import com.evalia.backEntrevistasInformes.repository.RespuestaRepository;
import com.evalia.backEntrevistasInformes.service.survey.IRespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RespuestaServiceImp implements IRespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;
    @Autowired
    private PreguntaPersonalizadaRepository preguntaPersonalizadaRepository;
    @Autowired
    private PreguntaRepository preguntaRepository;
    @Autowired
    private EntrevistaRepository entrevistaRepository;

    @Override
    public List<RespuestaEntity> findAll() {
        return respuestaRepository.findAll();
    }

    @Override
    public Optional<RespuestaEntity> findById(Long id) {
        return respuestaRepository.findById(id);
    }

    @Override
    public RespuestaEntity save(RespuestaEntity respuesta) {
        return respuestaRepository.save(respuesta);
    }

    @Override
    public void deleteById(Long id) {
        respuestaRepository.deleteById(id);
    }

    @Override
    public void guardarRespuestas(List<RespuestaEntity> respuestas) {
        for (RespuestaEntity r : respuestas) {

            // ⚠️ Validación segura antes del findById
            Long idEntrevista = (r.getEntrevista() != null) ? r.getEntrevista().getIdEntrevista() : null;
            if (idEntrevista == null) {
                throw new IllegalArgumentException("La respuesta no tiene entrevista válida");
            }

            EntrevistaEntity entrevista = entrevistaRepository.findById(idEntrevista)
                    .orElseThrow(() -> new RuntimeException("Entrevista no encontrada"));
            r.setEntrevista(entrevista);

            if (r.getPregunta() != null && r.getPregunta().getIdPregunta() != null) {
                r.setPregunta(preguntaRepository.findById(r.getPregunta().getIdPregunta()).orElse(null));
            }

            if (r.getPreguntaPersonalizada() != null
                    && r.getPreguntaPersonalizada().getIdPreguntaPersonalizada() != null) {
                r.setPreguntaPersonalizada(
                        preguntaPersonalizadaRepository
                                .findById(r.getPreguntaPersonalizada().getIdPreguntaPersonalizada())
                                .orElse(null));
            }

            respuestaRepository.save(r);
        }
    }

    @Override
    public void guardarRespuestasDesdeDTO(List<RespuestaDTO> dtos) {
        for (RespuestaDTO dto : dtos) {
            RespuestaEntity r = new RespuestaEntity();

            EntrevistaEntity entrevista = entrevistaRepository.findById(dto.getEntrevistaId())
                    .orElseThrow(() -> new RuntimeException("Entrevista no encontrada"));
            r.setEntrevista(entrevista);

            if (dto.getIdPregunta() != null) {
                r.setPregunta(preguntaRepository.findById(dto.getIdPregunta()).orElse(null));
            }

            if (dto.getIdPreguntaPersonalizada() != null) {
                r.setPreguntaPersonalizada(
                        preguntaPersonalizadaRepository.findById(dto.getIdPreguntaPersonalizada()).orElse(null));
            }

            r.setTextoRespuesta(dto.getTextoRespuesta());
            respuestaRepository.save(r);
        }
    }

}
