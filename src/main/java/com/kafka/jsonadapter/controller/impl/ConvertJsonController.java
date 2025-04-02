package com.kafka.jsonadapter.controller.impl;

import com.kafka.jsonadapter.controller.ConvertJsonApi;
import com.kafka.jsonadapter.dtos.PersonRequestDto;
import com.kafka.jsonadapter.service.impl.ConvertJsonServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertJsonController implements ConvertJsonApi {

    private final ConvertJsonServiceImpl convertJsonService;

    public ConvertJsonController(ConvertJsonServiceImpl convertJsonService) {
        this.convertJsonService = convertJsonService;
    }

    @Override
    public ResponseEntity<String> convertJson(PersonRequestDto personRequestDto) {
        try {
            convertJsonService.convertJson(personRequestDto);
            return ResponseEntity.ok("Converted successfully");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An unexpected error occured");
        }
    }
}
