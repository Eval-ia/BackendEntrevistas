package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;
import com.evalia.backEntrevistasInformes.model.entity.PreguntaPersonalizadaEntity;
import com.evalia.backEntrevistasInformes.repository.EntrevistaRepository;
import com.evalia.backEntrevistasInformes.repository.PreguntaPersonalizadaRepository;
import com.evalia.backEntrevistasInformes.service.survey.PreguntaPersonalizadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaPersonalizadaServiceImpl implements PreguntaPersonalizadaService {

    @Autowired
    private PreguntaPersonalizadaRepository personalizadaRepository;

    @Autowired
    private EntrevistaRepository entrevistaRepository;

    @Override
    public PreguntaPersonalizadaEntity guardar(String texto, Long idEntrevista) {
        EntrevistaEntity entrevista = entrevistaRepository.findById(idEntrevista)
                .orElseThrow(() -> new RuntimeException("Entrevista no encontrada"));

        PreguntaPersonalizadaEntity pregunta = new PreguntaPersonalizadaEntity();
        pregunta.setTexto(texto);
        pregunta.setEntrevista(entrevista);

        return personalizadaRepository.save(pregunta);
    }

    @Override
    public List<PreguntaPersonalizadaEntity> listarPorEntrevista(Long idEntrevista) {
        return personalizadaRepository.findByEntrevistaIdEntrevista(idEntrevista);
    }

    @Override
    public void eliminar(Long idPregunta) {
        personalizadaRepository.deleteById(idPregunta);
    }

}
