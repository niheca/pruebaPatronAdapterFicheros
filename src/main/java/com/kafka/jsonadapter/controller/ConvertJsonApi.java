package com.kafka.jsonadapter.controller;

import com.kafka.jsonadapter.commons.constants.ApiPathConstants;
import com.kafka.jsonadapter.dtos.PersonRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(ApiPathConstants.API_PATH + ApiPathConstants.VERSION_PATH)
public interface ConvertJsonApi {
    @PostMapping(value = ApiPathConstants.CONVERT_PATH)
    public ResponseEntity<String> convertJson(@RequestBody PersonRequestDto personRequestDto);
}
