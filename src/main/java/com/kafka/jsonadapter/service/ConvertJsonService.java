package com.kafka.jsonadapter.service;

import com.kafka.jsonadapter.dtos.PersonRequestDto;

public interface ConvertJsonService {
    public void convertJson(PersonRequestDto person);
}
