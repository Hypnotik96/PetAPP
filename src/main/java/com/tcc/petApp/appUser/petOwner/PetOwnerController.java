package com.tcc.petApp.appUser.petOwner;

import com.tcc.petApp.appUser.petOwner.api.PetOwnerRequest;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/petOwner")
public class PetOwnerController {

    @Autowired
    PetOwnerService petOwnerService;

    @Autowired
    PetOwnerMapper petOwnerMapper;

    // PET OWNER LIST
    @GetMapping
    public ResponseEntity<List<PetOwner>> findAllPetOwners() {
        return new ResponseEntity<List<PetOwner>>(petOwnerService.findAllPetOwners(), HttpStatus.OK);
    }

    //PET OWNER REQUEST LIST
    /*
    @GetMapping
    public ResponseEntity<List<PetOwnerRequest>> findAllPetOwners() {
        List<PetOwner> petOwnerList = petOwnerService.findAllPetOwners();
        return new ResponseEntity<List<PetOwnerRequest>>(petOwnerMapper
                .petOwnerListToPetOwnerRequestList(petOwnerList)
                , HttpStatus.OK);
    }
    */

    @GetMapping("/{id}")
    public ResponseEntity<PetOwnerRequest> findPetOwnerById(@PathVariable("id") Long id) {

        Optional<PetOwner> petOwner = petOwnerService.findPetOwnerById(id);

        return petOwner.map(value -> new ResponseEntity<PetOwnerRequest>
                (petOwnerMapper.petOwnerToPetOwnerRequest(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PetOwnerRequest> savePetOwner(@RequestBody PetOwnerRequest petOwnerRequest) {

        PetOwner petOwner = petOwnerMapper.petOwnerRequestToPetOwner(petOwnerRequest);
        petOwnerService.savePetOwner(petOwner);

        return new ResponseEntity<PetOwnerRequest>(petOwnerRequest, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetOwnerRequest> updatePetOwner(@PathVariable("id") Long id,
                                                          @RequestBody PetOwnerRequest petOwnerRequest) {

        Optional<PetOwner> petOwnerToUpdate = petOwnerService.findPetOwnerById(id);

        return petOwnerToUpdate.map(petOwner -> new ResponseEntity<PetOwnerRequest>
                (petOwnerMapper.petOwnerToPetOwnerRequest(
                        petOwnerService.updatePetOwner(
                                petOwnerMapper.updateSetterPetOwner(petOwner, petOwnerRequest))), HttpStatus.ACCEPTED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePetOwnerById(@PathVariable("id") Long id) {

        Optional<PetOwner> petOwner = petOwnerService.findPetOwnerById(id);

        if (petOwner.isPresent()) {
            petOwnerService.deletePetOwnerById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
