package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;
import com.evalia.backEntrevistasInformes.model.entity.PreguntaPersonalizadaEntity;
import com.evalia.backEntrevistasInformes.repository.PreguntaPersonalizadaRepository;
import com.evalia.backEntrevistasInformes.service.survey.IPreguntaPersonalizadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PreguntaPersonalizadaServiceImp implements IPreguntaPersonalizadaService {
    
    @Autowired
    private PreguntaPersonalizadaRepository preguntaPersonalizadaRepository;

    @Override
    public List<PreguntaPersonalizadaEntity> findAll() {
        return preguntaPersonalizadaRepository.findAll();
    }

    @Override
    public Optional<PreguntaPersonalizadaEntity> findById(Long id) {
        return preguntaPersonalizadaRepository.findById(id);
    }

    @Override
    public PreguntaPersonalizadaEntity save(PreguntaPersonalizadaEntity preguntaPersonalizada) {
        return preguntaPersonalizadaRepository.save(preguntaPersonalizada);
    }

    @Override
    public void deleteById(Long id) {
        preguntaPersonalizadaRepository.deleteById(id);
    }
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
