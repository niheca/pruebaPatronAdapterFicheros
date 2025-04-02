package com.kafka.jsonadapter.controller.handlerException;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.kafka.jsonadapter.commons.exceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceImpl {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        return new ResponseEntity<>(ex.getMessage(),ex.getHttpStatus());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleInvalidFormatException(HttpMessageNotReadableException ex) {
        CustomException customException;
        if (ex.getCause() instanceof InvalidFormatException) {
            return new ResponseEntity<>("Formato de fecha incorrecto. Debe ser dd/MM/yyyy", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Error en la solicitud", HttpStatus.BAD_REQUEST);
    }
}
