package com.freefood.dto;

import com.freefood.entity.Person;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto {
    private String name;

    public static PersonDto fromPerson(Person person){
        return PersonDto.builder()
                .name(person.getName())
                .build();
    }
}
