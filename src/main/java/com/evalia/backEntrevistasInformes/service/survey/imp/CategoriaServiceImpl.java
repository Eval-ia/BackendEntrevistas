package com.evalia.backEntrevistasInformes.service.survey.imp;

import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;
<<<<<<< HEAD
import com.evalia.backEntrevistasInformes.repository.CategoriaRepository;
=======
import com.evalia.backEntrevistasInformes.repository.categoriaRepository;
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b
import com.evalia.backEntrevistasInformes.service.survey.CategoriaService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
<<<<<<< HEAD
    private CategoriaRepository categoriaRepository;
=======
    private categoriaRepository categoriaRepository;
>>>>>>> fcef254659bde8cd3078d5d75d8a4866ebd9166b

    @Override
    public CategoriaEntity guardarCategoria(String nombre) {
        return categoriaRepository.findByNombreIgnoreCase(nombre)
                .orElseGet(() -> {
                    CategoriaEntity nueva = new CategoriaEntity();
                    nueva.setNombre(nombre);
                    return categoriaRepository.save(nueva);
                });
    }

    @Override
    public List<CategoriaEntity> getAllCategorias() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCategorias'");
    }

    @Override
    public Optional<CategoriaEntity> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public CategoriaEntity save(CategoriaEntity categoria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}
