package com.tcc.petApp.careService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CareServiceService {

    @Autowired
    CareServiceRepository careServiceRepository;

    public List<CareService> findAllCareServices() {
        return careServiceRepository.findAll();
    }

    public Optional<CareService> findCareServiceById(Long id) {
        return careServiceRepository.findById(id);
    }

    public CareService saveCareService(CareService careService) {
        return careServiceRepository.save(careService);
    }

    public CareService updateCareService(CareService careService) {
        return careServiceRepository.save(careService);
    }

    public void deleteCareServiceById(Long id) {
        careServiceRepository.deleteById(id);
    }
}
