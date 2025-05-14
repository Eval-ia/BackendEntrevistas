package com.evalia.backEntrevistasInformes.service.ia.informe;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;
import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;
import com.evalia.backEntrevistasInformes.repository.EntrevistaRepository;
import com.evalia.backEntrevistasInformes.repository.UsuarioRepository;
import com.evalia.backEntrevistasInformes.model.ia.informe.InformeGeneradoDTO;
import com.evalia.backEntrevistasInformes.model.preguntas.PreguntaRespuestaDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class InformeEntrevistaServiceImpl implements IInformeEntrevistaService {

    @Autowired
    private EntrevistaRepository entrevistaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ChatClient chatClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("classpath:templates/InformeEntrevista.st")
    private Resource promptTemplateFile;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.app2}")
    private String urlApp2;

    @Override
    public InformeGeneradoDTO generarInformeDesdeEntrevista(List<PreguntaRespuestaDTO> respuestas) {
        try {
            // 1. Convertir la lista a JSON
            String jsonEntrevista = objectMapper.writeValueAsString(respuestas);

            // 🔹 Preparar el prompt para la IA

            String rawTemplate = new String(promptTemplateFile.getInputStream().readAllBytes());
            PromptTemplate template = new PromptTemplate(rawTemplate);

            // 3. Sustituir variables
            Map<String, Object> variables = new HashMap<>();
            variables.put("entrevista_completa", jsonEntrevista);
            var prompt = template.create(variables);

            // 4. Llamada a GPT
            String respuestaGPT = chatClient.prompt(prompt).call().content();

            // 5. Parseo del resultado
            System.out.println("📦 Respuesta GPT:\n" + respuestaGPT);
            String contenido = respuestaGPT.trim()
                    .replaceAll("^```json\\s*", "")
                    .replaceAll("^```", "")
                    .replaceAll("```$", "")
                    .trim();
            JsonNode resultado = objectMapper.readTree(contenido);
            InformeGeneradoDTO dto = new InformeGeneradoDTO();
            dto.setInforme(resultado.get("valoracion_gpt").asText());
            dto.setFortalezas(resultado.get("fortalezas").asText());
            dto.setDebilidades(resultado.get("debilidades").asText());
            System.out.println(
                    "*****************************************************************************************************************************");

            System.out.println(dto);
            System.out.println(
                    "*****************************************************************************************************************************");

            return dto;

        } catch (Exception e) {
            throw new RuntimeException("❌ Error generando informe", e);
        }
    }

    @Override
    public void exportarCandidatosConInforme(List<UsuarioEntity> usuarios, String rutaArchivoCsv) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivoCsv))) {
            // Escribir cabecera
            writer.println("candidato_id,puesto,fortalezas,debilidades,valoracion_gpt");

            for (UsuarioEntity usuario : usuarios) {
                // Buscar la entrevista del candidato
                EntrevistaEntity entrevista = entrevistaRepository
                        .findFirstByCandidatoIdUsuario(usuario.getIdUsuario());

                if (entrevista != null && usuario.getInforme() != null) {
                    String candidatoId = "c" + usuario.getIdUsuario();
                    String puesto = entrevista.getPuesto().getNombre().replace(",", " ");
                    String fortalezas = usuario.getFortalezas().replace(",", " ");
                    String debilidades = usuario.getDebilidades().replace(",", " ");
                    String informe = usuario.getInforme().replace("\"", "'");

                    writer.printf("%s,%s,%s,%s,\"%s\"%n",
                            candidatoId, puesto, fortalezas, debilidades, informe);
                }
            }

            System.out.println("✅ CSV exportado correctamente en: " + rutaArchivoCsv);

        } catch (Exception e) {
            throw new RuntimeException("❌ Error exportando CSV", e);
        }
    }

    @Override
    public String enviarCsvParaRanking(File archivoCsv) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("file", new FileSystemResource(archivoCsv));

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            // ! PONER LA URL DEL ENDPOINT BIEN
            String url = urlApp2 + "/cargar-informes";
            return restTemplate.postForObject(url, requestEntity, String.class);

        } catch (Exception e) {
            throw new RuntimeException("Error enviando CSV a App2", e);
        }
    }

}