package com.kafka.jsonadapter.service.adapter.adapters.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.kafka.jsonadapter.dtos.PersonResponseDto;
import com.kafka.jsonadapter.service.adapter.JsonAdapter;
import com.kafka.jsonadapter.dtos.PersonRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class JsonToXmlAdapter extends JsonAdapter {

    private final String path = "src/main/resources/generatedFiles";

    @Override
    public void writeFile(PersonRequestDto person) {

        PersonResponseDto personResponse = transform(person);
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xmlContent = xmlMapper.writeValueAsString(personResponse);

            saveToFile(xmlContent, personResponse.getFullName(), "xml",path);
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir a XML: " + e.getMessage());
        }

    }
}
