package com.evalia.backEntrevistasInformes.service.ia.informe;


import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;
import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;
import com.evalia.backEntrevistasInformes.repository.EntrevistaRepository;
import com.evalia.backEntrevistasInformes.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class InformeEntrevistaServiceImpl implements IInformeEntrevistaService {

    @Autowired
    private EntrevistaRepository EntrevistaRepository;

    @Autowired
    private UsuarioRepository UsuarioRepository;

    @Autowired
    private ChatClient chatClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("classpath:templates/InformeEntrevista.st")
    private Resource promptTemplateFile;

    @Override
    public void generarInformeDesdeEntrevista(Long idEntrevista) {
        try {
            // 🔹 Obtener la entrevista con su contenido
            EntrevistaEntity entrevista = EntrevistaRepository.cargarEntrevistaCompleta(idEntrevista);



            // 🔹 Serializar toda la entrevista a JSON
            String jsonEntrevista = objectMapper.writeValueAsString(entrevista);

            // 🔹 Preparar el prompt para la IA
            String rawTemplate = new String(promptTemplateFile.getInputStream().readAllBytes());
            PromptTemplate template = new PromptTemplate(rawTemplate);

            Map<String, Object> variables = new HashMap<>();
            variables.put("entrevista_completa", jsonEntrevista);

            var prompt = template.create(variables);

            // 🔹 Llamar a la IA
            String informe = chatClient.prompt(prompt).call().content();

            // 🔹 Guardar el informe en el usuario entrevistado
            UsuarioEntity entrevistado = entrevista.getCandidato();
            entrevistado.setInforme(informe);
            UsuarioRepository.save(entrevistado);

            System.out.println("✅ Informe generado y guardado para el usuario ID " + entrevistado.getIdUsuario());

        } catch (Exception e) {
            System.out.println("❌ Error generando informe: " + e.getMessage());
            throw new RuntimeException("Error generando informe", e);
        }
    }
}