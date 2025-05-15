package com.evalia.backEntrevistasInformes.service.survey.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaTecnologiaEntity;
import com.evalia.backEntrevistasInformes.repository.CategoriaTecnologiaRepository;
import com.evalia.backEntrevistasInformes.service.survey.ICategoriaTecnologiaService;

@Service
public class CategoriaTecnologiaServiceImp implements ICategoriaTecnologiaService {
    
    @Autowired
    private CategoriaTecnologiaRepository categoriaTecnologiaRepository;

    @Override
    public List<CategoriaTecnologiaEntity> getAllCategoriasTecnologias() {
        return categoriaTecnologiaRepository.findAll();
    }
}
