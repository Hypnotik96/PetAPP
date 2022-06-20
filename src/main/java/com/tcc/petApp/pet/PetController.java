package com.tcc.petApp.pet;

import com.tcc.petApp.appUser.petOwner.PetOwner;
import com.tcc.petApp.appUser.petOwner.PetOwnerService;
import com.tcc.petApp.pet.api.PetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/pet")
public class PetController {

    @Autowired
    PetService petService;

    @Autowired
    PetMapper petMapper;

    @Autowired
    PetOwnerService petOwnerService;

    //PET LIST
    @GetMapping
    public ResponseEntity<List<Pet>> findAllPets() {
        return new ResponseEntity<List<Pet>>(petService.findAllPets(), HttpStatus.OK);
    }

    //PET REQUEST LIST
    /*
    @GetMapping
    public ResponseEntity<List<PetRequest>> findAllPets() {
        List<Pet> petList = petService.findAllPets();
        return new ResponseEntity<List<PetRequest>>(petMapper.petListToPetRequestList(petList),
                                                    HttpStatus.OK);
    }
    */

    @GetMapping("/{id}")
    public ResponseEntity<PetRequest> findPetById(@PathVariable("id") Long id) {

        Optional<Pet> pet = petService.findPetById(id);

        return pet.map(value -> new ResponseEntity<PetRequest>(petMapper.petToPetRequest(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PetRequest> savePet(@RequestBody PetRequest petRequest) {
        Pet pet = petMapper.petRequestToPet(petRequest);
        petService.savePet(pet);
        PetOwner petOwner = petOwnerService.findPetOwnerById(petRequest.getPetOwnerId()).get();
        List<Long> petIds = petOwner.getPetIds();
        petIds.add(pet.getId());
        petOwner.setPetIds(petIds);
        petOwnerService.updatePetOwner(petOwner);
        return new ResponseEntity<PetRequest>(petRequest, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetRequest> updatePet(@PathVariable("id") Long id, @RequestBody PetRequest petRequest) {

        Optional<Pet> petToUpdate = petService.findPetById(id);

        return petToUpdate.map(pet -> new ResponseEntity<PetRequest>
                        (petMapper.petToPetRequest(
                                petService.savePet(
                                        petMapper.updateSetterPet(pet, petRequest))),
                                HttpStatus.ACCEPTED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePetById(@PathVariable Long id) {

        Optional<Pet> pet = petService.findPetById(id);

        if (pet.isPresent()) {
            petService.deletePetById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}







