package com.tcc.petApp.appUser.petCaregiver;

import com.tcc.petApp.appUser.petCaregiver.api.PetCaregiverRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetCaregiverMapper {

    public PetCaregiverRequest petCaregiverToPetCaregiverRequest(PetCaregiver petCaregiver){
        return PetCaregiverRequest.builder()
            .cpf(petCaregiver.getCpf())
            .rg(petCaregiver.getRg())
            .name(petCaregiver.getName())
            .lastName(petCaregiver.getLastName())
            .phone(petCaregiver.getPhone())
            .email(petCaregiver.getEmail())
            .bornDate(petCaregiver.getBornDate())
            .password(petCaregiver.getPassword())
            .association(petCaregiver.getAssociation())
            .build();
    }

    public PetCaregiver petCaregiverRequestToPetCaregiver(PetCaregiverRequest petCaregiverRequest) {
        return PetCaregiver.builder()
                .cpf(petCaregiverRequest.getCpf())
                .rg(petCaregiverRequest.getRg())
                .name(petCaregiverRequest.getName())
                .lastName(petCaregiverRequest.getLastName())
                .phone(petCaregiverRequest.getPhone())
                .email(petCaregiverRequest.getEmail())
                .bornDate(petCaregiverRequest.getBornDate())
                .password(petCaregiverRequest.getPassword())
                .association(petCaregiverRequest.getAssociation())
                .build();
    }

    public PetCaregiver updateSetterPetCaregiver(PetCaregiver petCaregiver, PetCaregiverRequest petCaregiverRequest) {
        petCaregiver.setCpf(petCaregiverRequest.getCpf());
        petCaregiver.setRg(petCaregiverRequest.getRg());
        petCaregiver.setName(petCaregiverRequest.getName());
        petCaregiver.setLastName(petCaregiverRequest.getLastName());
        petCaregiver.setPhone(petCaregiverRequest.getPhone());
        petCaregiver.setEmail(petCaregiverRequest.getEmail());
        petCaregiver.setBornDate(petCaregiverRequest.getBornDate());
        petCaregiver.setPassword(petCaregiverRequest.getPassword());
        petCaregiver.setAssociation(petCaregiverRequest.getAssociation());
        return petCaregiver;
    }

    public List<PetCaregiverRequest> petCaregiverListToPetCaregiverRequestList(List<PetCaregiver> petCaregiverList) {
        List<PetCaregiverRequest> petCaregiverRequestList = new ArrayList<>();
        for (PetCaregiver petCaregiver:petCaregiverList) {
            petCaregiverRequestList.add(petCaregiverToPetCaregiverRequest(petCaregiver));
        }
        return petCaregiverRequestList;
    }
}
