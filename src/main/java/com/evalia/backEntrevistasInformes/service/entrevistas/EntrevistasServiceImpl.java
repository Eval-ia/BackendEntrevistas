package com.evalia.backEntrevistasInformes.service.entrevistas;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;
import com.evalia.backEntrevistasInformes.model.entity.PreguntaPersonalizadaEntity;
import com.evalia.backEntrevistasInformes.model.entity.RespuestaEntity;
import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;
import com.evalia.backEntrevistasInformes.model.entrevista.EntrevistaFinalizadaDTO;
import com.evalia.backEntrevistasInformes.model.ia.informe.InformeGeneradoDTO;
import com.evalia.backEntrevistasInformes.model.preguntas.PreguntaPersonalizadaDTO;
import com.evalia.backEntrevistasInformes.model.preguntas.PreguntaRespuestaDTO;
import com.evalia.backEntrevistasInformes.model.respuesta.RespuestaDTO;
import com.evalia.backEntrevistasInformes.repository.entrevistaRepository;
import com.evalia.backEntrevistasInformes.repository.preguntaPersonalizadaRepository;
import com.evalia.backEntrevistasInformes.repository.usuarioRepository;
import com.evalia.backEntrevistasInformes.service.ia.informe.IInformeEntrevistaService;
import com.evalia.backEntrevistasInformes.repository.respuestaRepository;
import com.evalia.backEntrevistasInformes.repository.puestoTrabajoRepository;
import com.evalia.backEntrevistasInformes.repository.preguntaRepository;

import jakarta.transaction.Transactional;

@Service
public class EntrevistasServiceImpl implements IEntrevistasService {
    @Autowired
    entrevistaRepository entrevistaRepository;
    @Autowired
    usuarioRepository usuarioRepository;
    @Autowired
    puestoTrabajoRepository puestoRepository;
    @Autowired
    respuestaRepository respuestaRepository;
    @Autowired
    preguntaRepository preguntaRepository;
    @Autowired
    preguntaPersonalizadaRepository preguntaPersonalizadaRepository;
    @Autowired
    IInformeEntrevistaService iInformeEntrevistaService;

    public String finalizarEntrevista(EntrevistaFinalizadaDTO dto) {
        // 1. Crear la EntrevistaEntity con los datos recibidos
        EntrevistaEntity entrevista = new EntrevistaEntity();
        entrevista.setFecha(LocalDate.now());
        entrevista.setEntrevistador(usuarioRepository.findById(dto.getIdEntrevistador()).orElseThrow());
        entrevista.setCandidato(usuarioRepository.findById(dto.getIdCandidato()).orElseThrow());
        entrevista.setPuesto(puestoRepository.findById(dto.getIdPuesto()).orElseThrow());
        entrevistaRepository.save(entrevista); // Necesario para generar ID

        // 2. Guardar preguntas personalizadas (si hay)
        Map<String, PreguntaPersonalizadaEntity> preguntasMap = new HashMap<>();
        for (PreguntaRespuestaDTO respuestaDTO : dto.getRespuestas()) {
            if (respuestaDTO.getTextoPreguntaPersonalizada() != null) {
                PreguntaPersonalizadaEntity preguntaPersonalizada = new PreguntaPersonalizadaEntity();
                preguntaPersonalizada.setTexto(respuestaDTO.getTextoPreguntaPersonalizada());
                preguntaPersonalizada.setEntrevista(entrevista);
                preguntaPersonalizadaRepository.save(preguntaPersonalizada);

                preguntasMap.put(respuestaDTO.getTextoPreguntaPersonalizada(), preguntaPersonalizada);
            }
        }

        // 3. Guardar las respuestas
        for (PreguntaRespuestaDTO respuestaDTO : dto.getRespuestas()) {
            RespuestaEntity respuesta = new RespuestaEntity();
            respuesta.setEntrevista(entrevista);

            if (respuestaDTO.getIdPregunta() != null) {
                respuesta.setPregunta(preguntaRepository.findById(respuestaDTO.getIdPregunta()).orElse(null));
            }

            if (respuestaDTO.getTextoPreguntaPersonalizada() != null) {
                PreguntaPersonalizadaEntity personalizada = preguntasMap
                        .get(respuestaDTO.getTextoPreguntaPersonalizada());
                respuesta.setPreguntaPersonalizada(personalizada);
            }

            respuesta.setTextoRespuesta(respuestaDTO.getRespuesta());
            respuestaRepository.save(respuesta);
        }

        // 4. Llamar a la IA para generar informe
        UsuarioEntity candidato = entrevista.getCandidato();
        InformeGeneradoDTO resultado = iInformeEntrevistaService.generarInformeDesdeEntrevista(dto.getRespuestas());
        
        candidato.setInforme(resultado.getInforme());
        candidato.setFortalezas(resultado.getFortalezas());
        candidato.setDebilidades(resultado.getDebilidades());

        usuarioRepository.save(candidato);

        // 5. Mensaje de éxito
        return "Entrevista finalizada y guardada correctamente";
    }

}
