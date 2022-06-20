package com.tcc.petApp.contract;

import com.tcc.petApp.appUser.petOwner.PetOwner;
import com.tcc.petApp.appUser.petOwner.PetOwnerService;
import com.tcc.petApp.careService.CareService;
import com.tcc.petApp.careService.CareServiceService;
import com.tcc.petApp.contract.api.ContractRequest;
import com.tcc.petApp.feedback.Feedback;
import com.tcc.petApp.feedback.api.FeedbackRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/v1/contract")
public class ContractController {

    @Autowired
    ContractService contractService;

    @Autowired
    ContractMapper contractMapper;

    @Autowired
    CareServiceService careServiceService;

    @Autowired
    PetOwnerService petOwnerService;

    //CONTRACT LIST
    @GetMapping
    public ResponseEntity<List<Contract>> findAllContracts() {
        return new ResponseEntity<List<Contract>>(contractService.findAllContracts(), HttpStatus.OK);

    }

    //CONTRACT REQUEST LIST
    /*
    @GetMapping
    public ResponseEntity<List<ContractRequest>> findAllContracts() {
        List<Contract> contractList = contractService.findAllContracts();
        return new ResponseEntity<List<ContractRequest>>(contractMapper.contractListToContractRequestList(contractList), HttpStatus.OK);
    }
     */

    @GetMapping("/{id}")
    public ResponseEntity<ContractRequest> findContractById(@PathVariable("id") Long id) {
        Optional<Contract> contract = contractService.findContractById(id);

        return contract.map(value -> new ResponseEntity<ContractRequest>(contractMapper.contracttoContractRequest(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ContractRequest> saveContract(@RequestBody ContractRequest contractRequest) {
        Contract contract = contractMapper.contractRequestToContract(contractRequest);
        contractService.saveContract(contract);
        CareService careService = careServiceService.findCareServiceById(contractRequest.getCareServiceId()).get();
        PetOwner petOwner = petOwnerService.findPetOwnerById(contractRequest.getPetOwnerId()).get();
        List<Long> serviceContractIds = careService.getContractIds();
        List<Long> ownerContractIds = petOwner.getContractIds();
        serviceContractIds.add(contract.getId());
        ownerContractIds.add(contract.getId());
        petOwner.setFeedbackIds(ownerContractIds);
        careService.setFeedbackIds(serviceContractIds);
        petOwnerService.updatePetOwner(petOwner);
        careServiceService.updateCareService(careService);
        return new ResponseEntity<ContractRequest>(contractRequest, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContractRequest> updateContract(@PathVariable("id") Long id, @RequestBody ContractRequest contractRequest) {
        Optional<Contract> contractToUpdate = contractService.findContractById(id);

        return contractToUpdate.map(contract -> new ResponseEntity<ContractRequest>
                        (contractMapper.contracttoContractRequest(contractService.saveContract
                                (contractMapper.updateSetterContract(
                                        contract, contractRequest))), HttpStatus.ACCEPTED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContractById(@PathVariable Long id) {
        Optional<Contract> contract = contractService.findContractById(id);

        if (contract.isPresent()) {
            contractService.deleteContractById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
