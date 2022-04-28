package com.tcc.petApp.appUser.petOwner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetOwnerService {

    @Autowired
    PetOwnerRepository petOwnerRepository;

    public List<PetOwner> findAllPetOwners() {
        return petOwnerRepository.findAll();
    }

    public Optional<PetOwner> findPetOwnerById(Long id) {
        return petOwnerRepository.findById(id);
    }

    public PetOwner savePetOwner(PetOwner petOwner) {
        return petOwnerRepository.save(petOwner);
    }

    public PetOwner updatePetOwner(PetOwner petOwner) {
        return petOwnerRepository.save(petOwner);
    }

    public void deletePetOwnerById(Long id) {
        petOwnerRepository.deleteById(id);
    }
}
