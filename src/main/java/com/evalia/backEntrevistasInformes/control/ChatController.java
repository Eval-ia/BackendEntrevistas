package com.evalia.backEntrevistasInformes.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // 🔹 Generar informe tras entrevista
    @PostMapping("/informe/{idEntrevista}")
    public void generarInforme(@PathVariable Long idEntrevista) {
        informeEntrevistaService.generarInformeDesdeEntrevista(idEntrevista);
    }

    // 🔹 Recomendación por categoría y nivel
    @PostMapping("/recomendacion")
    public ChatResponseDTO recomendarPorCategoriaYNivel(@RequestBody ChatRequestBusquedaDTO datos) {
        return recomendacionUsuarioService.recomendarUsuariosPorCategoriaYNivel(
            datos.getIdCategoria(), datos.getIdNivel()
        );
    }

    // 🔹 Recomendación por pregunta libre (chat)
    @PostMapping("/preguntar")
    public ChatResponseDTO recomendarPorPreguntaLibre(@RequestBody ChatRequestDTO datos) {
        return recomendacionUsuarioService.recomendarUsuariosPorPregunta(datos.getMensaje());
    }
}

