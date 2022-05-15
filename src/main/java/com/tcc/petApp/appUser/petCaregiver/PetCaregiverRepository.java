package com.tcc.petApp.appUser.petCaregiver;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface PetCaregiverRepository extends Repository<PetCaregiver, Long> {
    
    public List<PetCaregiver> findAll();
    public Optional<PetCaregiver> findById(Long id);
    public PetCaregiver save(PetCaregiver petCaregiver);
    public void deleteById(Long id);
}
