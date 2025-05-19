package com.evalia.backEntrevistasInformes.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;
import com.evalia.backEntrevistasInformes.model.ia.recomendacion.ChatRequestBusquedaDTO;
import com.evalia.backEntrevistasInformes.model.ia.recomendacion.ChatRequestDTO;
import com.evalia.backEntrevistasInformes.model.ia.recomendacion.ChatResponseDTO;
import com.evalia.backEntrevistasInformes.service.ia.informe.IInformeEntrevistaService;
import com.evalia.backEntrevistasInformes.service.ia.recomendacion.IRecomendacionUsuarioService;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private IInformeEntrevistaService informeEntrevistaService;

    @Autowired
    private IRecomendacionUsuarioService recomendacionUsuarioService;

    // 🔹 Recomendación por categoría y nivel
    @PostMapping("/recomendacion")
    public ChatResponseDTO recomendarPorCategoriaYNivel(@RequestBody ChatRequestBusquedaDTO datos) {
        return recomendacionUsuarioService.recomendarUsuariosPorCategoriaYNivel(
                datos.getIdCategoria(), datos.getIdNivel());
    }

    // 🔹 Recomendación por pregunta libre (chat)
    @PostMapping("/preguntar")
    public ChatResponseDTO recomendarPorPreguntaLibre(@RequestBody ChatRequestDTO datos) {
        return recomendacionUsuarioService.recomendarUsuariosPorPregunta(datos.getMensaje());
    }

    @PostMapping("/enviar-csv")
    public String enviarCsv(@RequestParam("archivo") MultipartFile archivo) throws IOException {
        // Convertir MultipartFile a File temporal
        File tempFile = File.createTempFile("upload-", ".csv");
        archivo.transferTo(tempFile);

        String respuesta = informeEntrevistaService.enviarCsvParaRanking(tempFile);

        // Limpieza
        tempFile.delete();

        return respuesta;
    }

    @GetMapping("/exportar-ranking")
    public String exportarYEnviarRanking() throws IOException {
        // Obtener todos los usuarios con informe
        List<UsuarioEntity> usuariosConInforme = recomendacionUsuarioService.obtenerUsuariosConInforme();

        // Crear archivo CSV temporal
        File archivoCsv = File.createTempFile("ranking-", ".csv");

        // Exportar al CSV
        informeEntrevistaService.exportarCandidatosConInforme(usuariosConInforme, archivoCsv.getAbsolutePath());

        // Enviar el CSV a App2
        String respuesta = informeEntrevistaService.enviarCsvParaRanking(archivoCsv);

        // Borrar archivo temporal
        archivoCsv.delete();

        return respuesta;
    }

}
