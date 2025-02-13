package com.efir.main.config;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GroqApiService {
    private final WebClient webClient;
    public GroqApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.groq.com/openai/v1").build();
    }
    public String callGroqApi(String apiKey, String model, String content) {
        return webClient.post()
                .uri("/chat/completions")
                .headers(headers -> headers.setBearerAuth(apiKey))
                .bodyValue("""
                    {
                        "model": "%s",
                        "messages": [{"role": "user", "content": "%s"}]
                    }
                    """.formatted(model, content))
                .retrieve()
                .bodyToMono(String.class)
                .block(); // Blocking call for simplicity
    }
}
