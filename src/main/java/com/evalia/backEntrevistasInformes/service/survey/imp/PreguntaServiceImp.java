package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.PreguntaEntity;
import com.evalia.backEntrevistasInformes.repository.PreguntaRepository;
import com.evalia.backEntrevistasInformes.service.survey.IPreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PreguntaServiceImp implements IPreguntaService {
    
    @Autowired
    private PreguntaRepository preguntaRepository;

    @Override
    public List<PreguntaEntity> findAll() {
        return preguntaRepository.findAll();
    }

    @Override
    public Optional<PreguntaEntity> findById(Long id) {
        return preguntaRepository.findById(id);
    }

    @Override
    public PreguntaEntity save(PreguntaEntity pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    public void deleteById(Long id) {
        preguntaRepository.deleteById(id);
    }

    @Override
    public List<PreguntaEntity> obtenerPorPuesto(Long idPuesto) {
        return preguntaRepository.findByPuesto_IdPuesto(idPuesto);
    }

    @Override
    public List<PreguntaEntity> obtenerGenericas() {
        return preguntaRepository.findByEsGenericaTrue();
    }

    // @Override
    // public Map<String, List<String>> obtenerPreguntasPorCategoriaYNivel(String categoria, String nivel) {

    //     List<String> genericas = preguntaRepository.findByPuesto_CategoriaAndPuesto_NivelAndEsGenerica(categoria, nivel, true)
    //     .stream()
    //     .map(PreguntaEntity::getTexto)
    //     .toList();

    //     List<String> especificas = preguntaRepository.findByPuesto_CategoriaAndPuesto_NivelAndEsGenerica(categoria, nivel,false)
    //     .stream()
    //     .map(PreguntaEntity::getTexto)
    //     .toList();

    //     Map<String,List<String>> resultado = new HashMap<>();
    //     resultado.put("genericas", genericas);
    //     resultado.put("especificas", especificas);

    //     return resultado;
    // }
}
