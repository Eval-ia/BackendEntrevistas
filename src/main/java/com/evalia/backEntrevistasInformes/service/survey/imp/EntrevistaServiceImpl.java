package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;
<<<<<<< HEAD
import com.evalia.backEntrevistasInformes.repository.EntrevistaRepository;
=======
import com.evalia.backEntrevistasInformes.repository.entrevistaRepository;
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b
import com.evalia.backEntrevistasInformes.service.survey.EntrevistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrevistaServiceImpl implements EntrevistaService {

    @Autowired
<<<<<<< HEAD
    private EntrevistaRepository entrevistaRepository;
=======
    private entrevistaRepository entrevistaRepository;
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b

    @Override
    public EntrevistaEntity crearEntrevista(EntrevistaEntity entrevista) {
        return entrevistaRepository.save(entrevista);
    }
}
