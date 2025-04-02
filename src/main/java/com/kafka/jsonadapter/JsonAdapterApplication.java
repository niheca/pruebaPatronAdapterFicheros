package com.kafka.jsonadapter;

import com.kafka.jsonadapter.dtos.PersonRequestDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsonAdapterApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonAdapterApplication.class, args);
    }

}
