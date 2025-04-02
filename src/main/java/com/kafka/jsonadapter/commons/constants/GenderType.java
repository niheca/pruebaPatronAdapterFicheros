package com.kafka.jsonadapter.commons.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.kafka.jsonadapter.commons.exceptions.CustomException;
import org.springframework.http.HttpStatus;

public enum GenderType {
    MALE, FEMALE, OTHER;

    @JsonCreator
    public static GenderType fromString(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "El campo gender no puede estar vacío");
        }
        try {
            return GenderType.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Género no válido: " + value + " (géneros soportados : male, female, other");
        }
    }
}