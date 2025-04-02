package com.kafka.jsonadapter.service.impl;

import com.kafka.jsonadapter.commons.exceptions.CustomException;
import com.kafka.jsonadapter.dtos.PersonRequestDto;
import com.kafka.jsonadapter.service.ConvertJsonService;
import com.kafka.jsonadapter.service.adapter.JsonAdapter;
import com.kafka.jsonadapter.service.adapter.JsonAdapterFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ConvertJsonServiceImpl implements ConvertJsonService {

    @Override
    public void convertJson(PersonRequestDto person) {
        JsonAdapter adapter = JsonAdapterFactory.getOutputFileAdapter(person.getTypeOfFile());
        adapter.writeFile(person);
    }
}
