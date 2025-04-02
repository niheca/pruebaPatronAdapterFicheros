package com.kafka.jsonadapter.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kafka.jsonadapter.commons.constants.GenderType;
import com.kafka.jsonadapter.commons.constants.TypeOfFile;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PersonRequestDto {
    private String name;
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date birthDate;

    private GenderType gender;

    private TypeOfFile typeOfFile; // a qué tipo de archivo quieres convertir el json de entrada -> json,excel,xml,csv

}
