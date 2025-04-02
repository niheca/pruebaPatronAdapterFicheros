package com.kafka.jsonadapter.commons.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.kafka.jsonadapter.commons.exceptions.CustomException;
import org.springframework.http.HttpStatus;

public enum TypeOfFile {
    JSON, XML, CSV, EXCEL;

    @JsonCreator
    public static TypeOfFile fromString(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "El campo typeOfFile no puede estar vacío");
        }
        try {
            return TypeOfFile.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Formato no soportado: " + value + " (formatos soportados : JSON, XML, CSV, EXCEL");
        }
    }
}
