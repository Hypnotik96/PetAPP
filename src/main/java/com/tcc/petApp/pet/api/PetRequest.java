package com.tcc.petApp.pet.api;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
public class PetRequest {

    private String name;

    private String type;

    private String breed;

    private char sex;

    private String size;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate bornDate;

    private String note;

}
