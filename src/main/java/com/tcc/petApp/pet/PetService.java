package com.tcc.petApp.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    public List<Pet> findAllPets() {
        return petRepository.findAll();
    }

    public Optional<Pet> findPetById(Long id) {
        return petRepository.findById(id);
    }

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet updatePet(Pet pet) {
        return petRepository.save(pet);
    }

    public void deletePetById(Long id) {
        petRepository.deleteById(id);
    }

}
