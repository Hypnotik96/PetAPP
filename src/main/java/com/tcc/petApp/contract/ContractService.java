package com.tcc.petApp.contract.api;

import com.tcc.petApp.contract.Contract;
import com.tcc.petApp.contract.ContractRepository;
import com.tcc.petApp.feedback.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService {

    @Autowired
    ContractRepository contractRepository;

    public List<Contract> findAllContracts() {
        return contractRepository.findAll();
    }

    public Optional<Contract> findContractById(Long id) {
        return contractRepository.findById(id);
    }

    public Contract saveContract(Contract contract) {
        return contractRepository.save(contract);
    }

    public Contract updateContract(Contract contract) {
        return contractRepository.save(contract);
    }

    public void deleteContractById(Long id) {
        contractRepository.deleteById(id);
    }
}
