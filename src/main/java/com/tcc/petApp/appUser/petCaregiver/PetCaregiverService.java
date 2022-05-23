package com.tcc.petApp.appUser.petCaregiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetCaregiverService {

    @Autowired
    PetCaregiverRepository petCaregiverRepository;

    public List<PetCaregiver> findAllPetCaregivers() {
        return petCaregiverRepository.findAll();
    }

    public Optional<PetCaregiver> findPetCaregiverById(Long id) {
        return petCaregiverRepository.findById(id);
    }

    public PetCaregiver savePetCaregiver(PetCaregiver petCaregiver) {
        return petCaregiverRepository.save(petCaregiver);
    }

    public PetCaregiver updateCaregiver(PetCaregiver petCaregiver) {
        return petCaregiverRepository.save(petCaregiver);
    }

    public void deletePetCaregiverById(Long id){
        petCaregiverRepository.deleteById(id);
    }
    
}
