package com.tcc.petApp.appUser.petCaregiver.api;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
public class PetCaregiverRequest {

    private String cpf;

    private String rg;

    private String name;

    private String lastName;

    private String phone;

    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate bornDate;

    private String password;

    private String association;



}
