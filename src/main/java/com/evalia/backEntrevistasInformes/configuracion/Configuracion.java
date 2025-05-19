package com.evalia.backEntrevistasInformes.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configuracion {
    
    @Bean ChatClient chatClient(OpenAiChatModel model) {
        return ChatClient.builder(model).build();
    }


    @Bean RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
