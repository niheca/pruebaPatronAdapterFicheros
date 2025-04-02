package com.kafka.jsonadapter.service.adapter.adapters.csv;

import com.kafka.jsonadapter.dtos.PersonResponseDto;
import com.kafka.jsonadapter.service.adapter.JsonAdapter;
import com.kafka.jsonadapter.dtos.PersonRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class JsonToCsvAdapter extends JsonAdapter {

    private final String path = "src/main/resources/generatedFiles";

    @Override
    public void writeFile(PersonRequestDto person) {
        PersonResponseDto personResponse = transform(person);

        String csvContent = "FullName,BirthDate,Age,Gender\n" +
                personResponse.getFullName() + "," +
                personResponse.getFormattedBirthDate() + "," +
                personResponse.getAge() + "," +
                personResponse.getGender();

        saveToFile(csvContent, personResponse.getFullName(), "csv",path);
    }
}
