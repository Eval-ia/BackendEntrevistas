package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.RespuestaEntity;
import com.evalia.backEntrevistasInformes.repository.respuestaRepository;
import com.evalia.backEntrevistasInformes.service.survey.IRespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RespuestaServiceImp implements IRespuestaService {
    
    @Autowired
    private respuestaRepository respuestaRepository;

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
}
