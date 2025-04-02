package com.kafka.jsonadapter.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PersonResponseDto {
    private String fullName; //Junte el Name y el lastName
    private String formattedBirthDate; // pasará de este formato de fecha 'dd/MM/yyyy' a este 'yyyy-MM-dd'
    private Integer age; // teniendo en cuena la fecha de nacimiento, la edad actual correspondiente
    private String gender; //M(male) ,F(female),X(other)
}
