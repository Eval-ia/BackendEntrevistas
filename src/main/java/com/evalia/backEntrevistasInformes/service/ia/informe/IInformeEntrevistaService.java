package com.evalia.backEntrevistasInformes.service.ia.informe;

import java.io.File;
import java.util.List;

import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;
import com.evalia.backEntrevistasInformes.model.ia.informe.InformeGeneradoDTO;
import com.evalia.backEntrevistasInformes.model.preguntas.PreguntaRespuestaDTO;


public interface IInformeEntrevistaService {
    InformeGeneradoDTO generarInformeDesdeEntrevista(List<PreguntaRespuestaDTO> respuestas);
    String enviarCsvParaRanking(File archivoCsv);
    void exportarCandidatosConInforme(List<UsuarioEntity> usuarios, String rutaArchivoCsv);
}
