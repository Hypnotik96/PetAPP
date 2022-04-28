package com.tcc.petApp.appUser.petOwner;

import com.tcc.petApp.appUser.petOwner.api.PetOwnerRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetOwnerMapper {

    public PetOwnerRequest petOwnerToPetOwnerRequest(PetOwner petOwner) {
        return PetOwnerRequest.builder()
                .cpf(petOwner.getCpf())
                .rg(petOwner.getRg())
                .name(petOwner.getName())
                .lastName(petOwner.getLastName())
                .phone(petOwner.getPhone())
                .email(petOwner.getEmail())
                .bornDate(petOwner.getBornDate())
                .password(petOwner.getPassword()) //perguntar a marcelo
                .build();
    }

    public PetOwner petOwnerRequestToPetOwner(PetOwnerRequest petOwnerRequest) {
        return PetOwner.builder()
                .cpf(petOwnerRequest.getCpf())
                .rg(petOwnerRequest.getRg())
                .name(petOwnerRequest.getName())
                .lastName(petOwnerRequest.getLastName())
                .phone(petOwnerRequest.getPhone())
                .email(petOwnerRequest.getEmail())
                .bornDate(petOwnerRequest.getBornDate())
                .password(petOwnerRequest.getPassword()) //perguntar a marcelo
                .build();
    }

    public PetOwner updateSetterPetOwner(PetOwner petOwner, PetOwnerRequest petOwnerRequest) {
        petOwner.setCpf(petOwnerRequest.getCpf());
        petOwner.setRg(petOwnerRequest.getRg());
        petOwner.setName(petOwnerRequest.getName());
        petOwner.setLastName(petOwnerRequest.getLastName());
        petOwner.setPhone(petOwnerRequest.getPhone());
        petOwner.setEmail(petOwnerRequest.getEmail());
        petOwner.setBornDate(petOwnerRequest.getBornDate());
        petOwner.setPassword(petOwnerRequest.getPassword());
        return petOwner;
    }

    public List<PetOwnerRequest> petOwnerListToPetOwnerRequestList(List<PetOwner> petOwnerList) {
        List<PetOwnerRequest> petOwnerRequestList = new ArrayList<>();
        for (PetOwner petOwner:petOwnerList) {
            petOwnerRequestList.add(petOwnerToPetOwnerRequest(petOwner));
        }
        return petOwnerRequestList;
    }
}
