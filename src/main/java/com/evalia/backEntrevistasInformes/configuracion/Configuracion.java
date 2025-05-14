package com.evalia.backEntrevistasInformes.configuracion;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.api.OpenAiApi;


import org.springframework.web.client.RestTemplate;

@Configuration
public class Configuracion {
    
     @Bean
    public ChatClient chatClient(OpenAiChatModel model) {
        return ChatClient.builder(model).build();
    }


     @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
