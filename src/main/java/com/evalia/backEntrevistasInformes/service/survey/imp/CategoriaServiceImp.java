package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;
import com.evalia.backEntrevistasInformes.repository.categoriaRepository;
import com.evalia.backEntrevistasInformes.service.survey.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImp implements ICategoriaService {
    
    @Autowired
    private categoriaRepository categoriaRepository;

    @Override
    public List<CategoriaEntity> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<CategoriaEntity> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public CategoriaEntity save(CategoriaEntity categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
