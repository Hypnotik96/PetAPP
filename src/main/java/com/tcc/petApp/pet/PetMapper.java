package com.tcc.petApp.pet;

import com.tcc.petApp.pet.api.PetRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetMapper {

    public PetRequest petToPetRequest(Pet pet) {
        return PetRequest.builder()
                .name(pet.getName())
                .type(pet.getType())
                .breed(pet.getBreed())
                .sex(pet.getSex())
                .size(pet.getSize())
                .bornDate(pet.getBornDate())
                .note(pet.getNote())
                .build();
    }

    public Pet petRequestToPet(PetRequest petRequest) {
        return Pet.builder()
                .name(petRequest.getName())
                .type(petRequest.getType())
                .breed(petRequest.getBreed())
                .sex(petRequest.getSex())
                .size(petRequest.getSize())
                .bornDate(petRequest.getBornDate())
                .note(petRequest.getNote())
                .build();
    }

    public Pet updateSetterPet(Pet pet, PetRequest petRequest) {
        pet.setNote(petRequest.getNote());
        return pet;
    }

    public List<PetRequest> petListToPetRequestList(List<Pet> petList) {
        List<PetRequest> petRequestList = new ArrayList<>();
        for (Pet pet:petList) {
            petRequestList.add(petToPetRequest(pet));
        }
        return petRequestList;
    }
}
