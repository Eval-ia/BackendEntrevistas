package com.evalia.backEntrevistasInformes.service.ia.informe;

<<<<<<< HEAD

=======
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
>>>>>>> main
import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
<<<<<<< HEAD
=======
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
>>>>>>> main
import org.springframework.stereotype.Service;

import com.evalia.backEntrevistasInformes.model.entity.EntrevistaEntity;
import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;
<<<<<<< HEAD
import com.evalia.backEntrevistasInformes.repository.entrevistaRepository;
import com.evalia.backEntrevistasInformes.repository.usuarioRepository;
=======
import com.evalia.backEntrevistasInformes.repository.EntrevistaRepository;
import com.evalia.backEntrevistasInformes.model.ia.informe.InformeGeneradoDTO;
import com.evalia.backEntrevistasInformes.model.preguntas.PreguntaRespuestaDTO;
import com.fasterxml.jackson.databind.JsonNode;
>>>>>>> main
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class InformeEntrevistaServiceImpl implements IInformeEntrevistaService {

    @Autowired
    private entrevistaRepository EntrevistaRepository;

<<<<<<< HEAD
    @Autowired
    private usuarioRepository UsuarioRepository;
=======
    // @Autowired
    // private UsuarioRepository usuarioRepository;
>>>>>>> main

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

<<<<<<< HEAD
            // 🔹 Guardar el informe en el usuario entrevistado
            UsuarioEntity entrevistado = entrevista.getCandidato();
            entrevistado.setInforme(informe);
            UsuarioRepository.save(entrevistado);

            System.out.println("✅ Informe generado y guardado para el usuario ID " + entrevistado.getIdUsuario());
=======
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

            return dto;
>>>>>>> main

        } catch (Exception e) {
            System.out.println("❌ Error generando informe: " + e.getMessage());
            throw new RuntimeException("Error generando informe", e);
        }
    }
<<<<<<< HEAD
=======

    @Override
    public void exportarCandidatosConInforme(List<UsuarioEntity> usuarios, String rutaArchivoCsv) {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(rutaArchivoCsv),
                StandardCharsets.UTF_8);
                PrintWriter writer = new PrintWriter(osw)) {

            writer.write('\uFEFF'); // BOM para Excel

            String sep = ";"; // o ";"

            // Cabecera
            writer.println(String.join(sep,
                    "\"candidato_id\"", "\"puesto\"", "\"fortalezas\"", "\"debilidades\"", "\"valoracion_gpt\""));

            for (UsuarioEntity usuario : usuarios) {
                EntrevistaEntity entrevista = entrevistaRepository
                        .findFirstByCandidatoIdUsuario(usuario.getIdUsuario());

                if (entrevista != null && usuario.getInforme() != null && !usuario.getInforme().isBlank()) {
                    String[] fila = {
                            "\"" + usuario.getIdUsuario() + "\"",
                            "\"" + entrevista.getPuesto().getNombre().replace("\"", "\"\"") + "\"",
                            "\"" + usuario.getFortalezas().replace("\"", "\"\"") + "\"",
                            "\"" + usuario.getDebilidades().replace("\"", "\"\"") + "\"",
                            "\"" + usuario.getInforme().replace("\"", "\"\"") + "\""
                    };
                    writer.println(String.join(sep, fila));
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

>>>>>>> main
}