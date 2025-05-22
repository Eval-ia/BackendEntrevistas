// package com.evalia.backEntrevistasInformes.service.ia.recomendacion;

// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import org.springframework.ai.chat.client.ChatClient;
// import org.springframework.ai.chat.prompt.PromptTemplate;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.core.io.Resource;
// import org.springframework.stereotype.Service;

// import com.evalia.backEntrevistasInformes.model.entity.CategoriaEntity;
// import com.evalia.backEntrevistasInformes.model.entity.NivelEntity;
// import com.evalia.backEntrevistasInformes.model.entity.UsuarioEntity;
// import com.evalia.backEntrevistasInformes.model.ia.recomendacion.ChatResponseDTO;
// import com.evalia.backEntrevistasInformes.repository.nivelRepository;
// import com.evalia.backEntrevistasInformes.repository.categoriaRepository;
// import com.evalia.backEntrevistasInformes.repository.usuarioRepository;
// import com.fasterxml.jackson.databind.ObjectMapper;

// @Service
// public class RecomendacionUsuarioServiceImpl implements IRecomendacionUsuarioService {

//     @Autowired
//     private categoriaRepository categoriaRepository;

//     @Autowired
//     private nivelRepository nivelTecnologiaRepository;

//     @Autowired
//     private usuarioRepository usuarioRepository;

//     @Autowired
//     private ChatClient chatClient;

//     @Autowired
//     private ObjectMapper objectMapper;

//     @Value("classpath:templates/RecomendacionUsuarios.st")
//     private Resource promptTemplateFile;

//     @Value("classpath:templates/RecomendacionPorPregunta.st")
//     private Resource promptLibreTemplate;

//     @Override
//     public ChatResponseDTO recomendarUsuariosPorCategoriaYNivel(Long idCategoria, Long idNivel) {
//         try {
//             CategoriaEntity categoria = categoriaRepository.findById(idCategoria)
//                 .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

//             NivelEntity nivel = nivelTecnologiaRepository.findById(idNivel)
//                 .orElseThrow(() -> new RuntimeException("Nivel no encontrado"));

//             List<UsuarioEntity> usuariosConInforme = usuarioRepository.findByInformeIsNotNull();

//             List<Map<String, Object>> informes = usuariosConInforme.stream().map(usuario -> {
//                 Map<String, Object> map = new HashMap<>();
//                 map.put("id", usuario.getIdUsuario());
//                 map.put("informe", usuario.getInforme());
//                 return map;
//             }).toList();

//             Map<String, Object> variables = new HashMap<>();
//             variables.put("informes", objectMapper.writeValueAsString(informes));
//             variables.put("categoria", categoria.getNombre());
//             variables.put("nivel", nivel.getNombre());

//             String templateRaw = new String(promptTemplateFile.getInputStream().readAllBytes());
//             PromptTemplate template = new PromptTemplate(templateRaw);
//             String respuesta = chatClient.prompt(template.create(variables)).call().content();

//             return objectMapper.readValue(respuesta, ChatResponseDTO.class);

//         } catch (Exception e) {
//             throw new RuntimeException("Error recomendando usuarios por categoría y nivel", e);
//         }
//     }

//     @Override
//     public ChatResponseDTO recomendarUsuariosPorPregunta(String mensaje) {
//         try {
//             List<UsuarioEntity> usuariosConInforme = usuarioRepository.findByInformeIsNotNull();

//             List<Map<String, Object>> informes = usuariosConInforme.stream().map(usuario -> {
//                 Map<String, Object> map = new HashMap<>();
//                 map.put("id", usuario.getIdUsuario());
//                 map.put("informe", usuario.getInforme());
//                 return map;
//             }).toList();

//             Map<String, Object> variables = new HashMap<>();
//             variables.put("mensaje_usuario", mensaje);
//             variables.put("informes", objectMapper.writeValueAsString(informes));

//             String templateRaw = new String(promptLibreTemplate.getInputStream().readAllBytes());
//             PromptTemplate template = new PromptTemplate(templateRaw);
//             String respuesta = chatClient.prompt(template.create(variables)).call().content();

//             return objectMapper.readValue(respuesta, ChatResponseDTO.class);

//         } catch (Exception e) {
//             throw new RuntimeException("Error recomendando usuarios por pregunta libre", e);
//         }
//     }

    
// }