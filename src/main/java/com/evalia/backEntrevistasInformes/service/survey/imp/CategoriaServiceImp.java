package com.evalia.backEntrevistasInformes.service.survey.imp;

<<<<<<< HEAD
import com.evalia.backEntrevistasInformes.model.entity.TecnologiaEntity;
import com.evalia.backEntrevistasInformes.repository.categoriaRepository;
=======
import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;
import com.evalia.backEntrevistasInformes.repository.CategoriaRepository;
>>>>>>> main
import com.evalia.backEntrevistasInformes.service.survey.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImp implements ICategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<TecnologiaEntity> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<TecnologiaEntity> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public TecnologiaEntity save(TecnologiaEntity categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
