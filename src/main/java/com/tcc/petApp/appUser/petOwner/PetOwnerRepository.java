package com.tcc.petApp.appUser.petOwner;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface PetOwnerRepository extends Repository<PetOwner, Long> {

    public List<PetOwner> findAll();
    public Optional<PetOwner> findById(Long id);
    public PetOwner save(PetOwner petOwner);
    public void deleteById(Long id);
}
