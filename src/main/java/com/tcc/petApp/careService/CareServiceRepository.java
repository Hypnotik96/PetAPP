package com.tcc.petApp.careService;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface CareServiceRepository extends Repository<CareService, Long> {

    public List<CareService> findAll();

    public Optional<CareService> findById(Long id);

    public CareService save(CareService careService);

    public void deleteById(Long id);


}
