package com.evalia.backEntrevistasInformes.service.entrevistas;

import java.io.File;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;
import com.evalia.backEntrevistasInformes.model.entity.PreguntaPersonalizadaEntity;
import com.evalia.backEntrevistasInformes.model.entity.RespuestaEntity;
import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;
import com.evalia.backEntrevistasInformes.model.entrevista.EntrevistaFinalizadaDTO;
import com.evalia.backEntrevistasInformes.model.ia.informe.InformeGeneradoDTO;
import com.evalia.backEntrevistasInformes.model.preguntas.PreguntaRespuestaDTO;
import com.evalia.backEntrevistasInformes.repository.EntrevistaRepository;
import com.evalia.backEntrevistasInformes.repository.PreguntaPersonalizadaRepository;
import com.evalia.backEntrevistasInformes.repository.PreguntaRepository;
import com.evalia.backEntrevistasInformes.repository.PuestoTrabajoRepository;
import com.evalia.backEntrevistasInformes.repository.RespuestaRepository;
import com.evalia.backEntrevistasInformes.repository.UsuarioRepository;
import com.evalia.backEntrevistasInformes.service.ia.informe.IInformeEntrevistaService;
import com.evalia.backEntrevistasInformes.util.PdfGeneratorService;

import jakarta.transaction.Transactional;

@Service
public class EntrevistasServiceImpl implements IEntrevistasService {
    @Autowired
    EntrevistaRepository entrevistaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    PuestoTrabajoRepository puestoRepository;
    @Autowired
    RespuestaRepository respuestaRepository;
    @Autowired
    PreguntaRepository preguntaRepository;
    @Autowired
    PreguntaPersonalizadaRepository preguntaPersonalizadaRepository;
    @Autowired
    IInformeEntrevistaService iInformeEntrevistaService;

    @Autowired
    PdfGeneratorService pdfGeneratorService;

    @Transactional
    public String finalizarEntrevista(EntrevistaFinalizadaDTO dto) {
        // 1. Crear la EntrevistaEntity con los datos recibidos
        EntrevistaEntity entrevista = new EntrevistaEntity();
        entrevista.setFecha(LocalDate.now());

        UsuarioEntity entrevistador = usuarioRepository.findById(dto.getIdEntrevistador())
                .orElseThrow(() -> new RuntimeException("Entrevistador no encontrado"));

        UsuarioEntity candidato = usuarioRepository.findById(dto.getIdCandidato())
                .orElseThrow(() -> new RuntimeException("Candidato no encontrado"));

        entrevista.setEntrevistador(entrevistador);
        entrevista.setCandidato(candidato);
        entrevista.setPuesto(puestoRepository.findById(dto.getIdPuesto())
                .orElseThrow(() -> new RuntimeException("Puesto no encontrado")));

        entrevistaRepository.save(entrevista); // Genera ID

        // 2. Guardar preguntas personalizadas (si hay)
        Map<String, PreguntaPersonalizadaEntity> preguntasMap = new HashMap<>();
        for (PreguntaRespuestaDTO respuestaDTO : dto.getRespuestas()) {
            if (respuestaDTO.getTextoPreguntaPersonalizada() != null) {
                PreguntaPersonalizadaEntity preguntaPersonalizada = new PreguntaPersonalizadaEntity();
                preguntaPersonalizada.setTexto(respuestaDTO.getTextoPreguntaPersonalizada());
                preguntaPersonalizada.setEntrevista(entrevista);
                preguntaPersonalizadaRepository.save(preguntaPersonalizada);

                preguntasMap.put(respuestaDTO.getTextoPreguntaPersonalizada(), preguntaPersonalizada);
            }
        }

        // 3. Guardar respuestas
        for (PreguntaRespuestaDTO respuestaDTO : dto.getRespuestas()) {
            RespuestaEntity respuesta = new RespuestaEntity();
            respuesta.setEntrevista(entrevista);

            if (respuestaDTO.getIdPregunta() != null) {
                respuesta.setPregunta(preguntaRepository.findById(respuestaDTO.getIdPregunta())
                        .orElse(null));
            }

            if (respuestaDTO.getTextoPreguntaPersonalizada() != null) {
                PreguntaPersonalizadaEntity personalizada = preguntasMap
                        .get(respuestaDTO.getTextoPreguntaPersonalizada());
                respuesta.setPreguntaPersonalizada(personalizada);
            }

            respuesta.setTextoRespuesta(respuestaDTO.getRespuesta());
            respuestaRepository.save(respuesta);
        }

        // 4. Generar informe con IA
        InformeGeneradoDTO resultado = iInformeEntrevistaService.generarInformeDesdeEntrevista(dto.getRespuestas());

        if (resultado != null) {
            candidato.setInforme(resultado.getInforme());
            candidato.setFortalezas(resultado.getFortalezas());
            candidato.setDebilidades(resultado.getDebilidades());
            usuarioRepository.saveAndFlush(candidato);
        }

        // 5. Exportar CSV
        List<UsuarioEntity> candidatosConInforme = Collections.singletonList(candidato);
        new File("temp").mkdirs();
        String rutaCsv = "temp/candidato_" + candidato.getIdUsuario() + ".csv";
        iInformeEntrevistaService.exportarCandidatosConInforme(candidatosConInforme, rutaCsv);

        // 6. Enviar CSV a App2 (comentado)
        /*
         * File archivoCsv = new File(rutaCsv);
         * iInformeEntrevistaService.enviarCsvParaRanking(archivoCsv);
         */

        System.out.println("✅ Envío a App2 pendiente: CSV generado correctamente en " + rutaCsv);


        
        String rutaPdf = pdfGeneratorService.generarPdf(entrevista, dto.getRespuestas());
        System.out.println("✅ Informe PDF generado en: " + rutaPdf);


        return "Entrevista finalizada y guardada correctamente";
    }

}
