package com.kafka.jsonadapter.service.adapter.adapters.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.jsonadapter.dtos.PersonResponseDto;
import com.kafka.jsonadapter.service.adapter.JsonAdapter;
import com.kafka.jsonadapter.dtos.PersonRequestDto;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class JsonToJsonAdapter extends JsonAdapter {

    private final String path = "src/main/resources/generatedFiles";


    @Override
    public void writeFile(PersonRequestDto person) {
        PersonResponseDto personResponse = transform(person);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonContent = objectMapper.writeValueAsString(personResponse);

            saveToFile(jsonContent, personResponse.getFullName(), "json" , path);
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir a JSON: " + e.getMessage());
        }
    }
}
