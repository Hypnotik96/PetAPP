package com.tcc.petApp.contract;

import java.util.List;
import java.util.Optional;

public interface ContractRepository {

    public List<Contract> findAll();

    public Optional<Contract> findById(Long id);

    public Contract save();

    public void deleteById(Long id);
}
