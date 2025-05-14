package com.evalia.backEntrevistasInformes.service.survey;

import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;
import java.util.List;
import java.util.Optional;

public interface INivelService {
    List<NivelEntity> findAll();
    Optional<NivelEntity> findById(Long id);
    NivelEntity save(NivelEntity nivel);
    void deleteById(Long id);
}
