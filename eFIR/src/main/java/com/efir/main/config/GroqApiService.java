package com.efir.main.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class GroqApiService {
    private final WebClient webClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public GroqApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.groq.com/openai/v1").build();
    }

    public Mono<String> callGroqApi(String apiKey, String model, String content) {
        try {
            // Construct JSON payload using a Map
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", model);
            requestBody.put("messages", new Object[]{Map.of("role", "user", "content", content)});

            String requestBodyJson = objectMapper.writeValueAsString(requestBody);

            return webClient.post()
                    .uri("/chat/completions")
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                    .header(HttpHeaders.CONTENT_TYPE, "application/json")
                    .bodyValue(requestBodyJson)
                    .retrieve()
                    .bodyToMono(String.class)
                    .flatMap(response -> {
                        try {
                            // Parse JSON response to extract only `content`
                            JsonNode rootNode = objectMapper.readTree(response);
                            JsonNode contentNode = rootNode.path("choices").get(0).path("message").path("content");
                            return Mono.just(contentNode.asText());
                        } catch (Exception e) {
                            return Mono.error(new RuntimeException("Failed to parse response", e));
                        }
                    });

        } catch (Exception e) {
            return Mono.error(new RuntimeException("JSON serialization failed", e));
        }
    }
}
