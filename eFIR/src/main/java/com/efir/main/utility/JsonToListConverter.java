package com.efir.main.utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class JsonToListConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public  List<String> convertJsonToList(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, new TypeReference<List<String>>() {});
        } catch (Exception e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
            return List.of("Not Identified"); // Default value if parsing fails
        }
    }
}