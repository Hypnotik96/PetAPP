package com.tcc.petApp.pet;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends Repository<Pet, Long> {

    public List<Pet> findAll();
    public Optional<Pet> findById(Long id);
    public Pet save(Pet pet);
    public void deleteById(Long id);

}
