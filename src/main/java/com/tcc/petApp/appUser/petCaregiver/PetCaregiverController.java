package com.tcc.petApp.appUser.petCaregiver;

import com.tcc.petApp.appUser.petCaregiver.api.PetCaregiverRequest;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.spripackage com.tcc.petApp.appUser.petCaregiver;

public class PetCaregiverController {
    
}
ngframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/petCaregiver")

public class PetCaregiverController {

    @Autowired
    PetCaregiverService petCaregiverService;

    @Autowired
    PetCaregiverMapper petCaregiverMapper;

    // PET CAREGIVER LIST
    @GetMapping
    public ResponseEntity<List<PetCaregiver>> findAllPetCaregivers() {
        return new ResponseEntity<List<PetCaregiver>>(petCaregiverService.findAllPetCaregivers(), HttpStatus.OK);
    }

    //PET CAREGIVER REQUEST LIST
    @GetMapping("/{id}")
    public ResponseEntity<PetCaregiverRequest> findPetCaregiverById(@PathVariable("id") Long id) {

        Optional<PetCaregiver> petCaregiver = petCaregiverService.findPetCaregiverById(id);

        return petCaregiver.map(value -> new ResponseEntity<PetCaregiverRequest>
            (petCaregiverMapper.petCaregiverToPetCaregiverRequest(value), HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PetCaregiverRequest> savePetCaregiver(@RequestBody PetCaregiverRequest petCaregiverRequest) {
        
        PetCaregiver petCaregiver = petCaregiverMapper.petCaregiverRequestToPetCaregiver(petCaregiverRequest);
        petCaregiverService.savePetCaregiver(petCaregiver);

        return new ResponseEntity<PetCaregiverRequest>(petCaregiverRequest, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PetCaregiverRequest> updatePetCaregiver(@PathVariable("id") Long id,
                                                                  @RequestBody PetCaregiverRequest petCaregiverRequest) {
        Optional<PetCaregiver> petCaregiverToUpdate = petCaregiverService.findPetCaregiverById(id);

        return petCaregiverToUpdate.map(petCaregiver -> new ResponseEntity<PetCaregiverRequest>
                (petCaregiverMapper.petCaregiverToPetCaregiverRequest(
                    petCaregiverService.updateCaregiver(
                        petCaregiverMapper.updateSetterPetCaregiver(petCaregiver, petCaregiverRequest))), HttpStatus.ACCEPTED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePetCaregiverById(@PathVariable("id") Long id) {
        Optional<PetCaregiver> petCaregiver = petCaregiverService.findPetCaregiverById(id);

        if (petCaregiver.isPresent()) {
            petCaregiverService.deletePetCaregiverById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
