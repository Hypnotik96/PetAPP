package com.tcc.petApp.careService;

import com.tcc.petApp.careService.api.CareServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/careService")
public class CareServiceController {

    @Autowired
    CareServiceService careServiceService;

    @Autowired
    CareServiceMapper careServiceMapper;

    // CARE SERVICE LIST
    @GetMapping
    public ResponseEntity<List<CareService>> findAllCareServicess() {
        return new ResponseEntity<List<CareService>>(careServiceService.findAllCareServices(), HttpStatus.OK);
    }

    // CARE SERVICE REQUEST LIST
    /*
    @GetMapping
    public ResponseEntity<List<CareServiceRequest>> findAllCareServices() {
        List<CareService> careServiceList = careServiceService.findAllCareServices();
        return new ResponseEntity<List<CareServiceRequest>>(careServiceMapper
                .careServiceListToCareServiceRequestList(careServiceList),
                HttpStatus.OK);
    }
     */

    @GetMapping("/{id}")
    public ResponseEntity<CareServiceRequest> findCareServiceById(@PathVariable("id") Long id) {

        Optional<CareService> careService = careServiceService.findCareServiceById(id);

        return careService.map(value -> new ResponseEntity<CareServiceRequest>
               (careServiceMapper.careServiceToCareServiceRequest(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CareServiceRequest> saveCareService(@RequestBody CareServiceRequest careServiceRequest) {

        CareService careService = careServiceMapper.careServiceRequestToCareService(careServiceRequest);
        careServiceService.saveCareService(careService);

        return new ResponseEntity<CareServiceRequest>(careServiceRequest, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CareServiceRequest> updateCareService(@PathVariable("id") Long id,
                                                                @RequestBody CareServiceRequest careServiceRequest) {

        Optional<CareService> careServiceToUpdate = careServiceService.findCareServiceById(id);

        return careServiceToUpdate.map(careService -> new ResponseEntity<CareServiceRequest>
                (careServiceMapper.careServiceToCareServiceRequest(
                        careServiceService.updateCareService(
                                careServiceMapper.updateSetterCareService(careService, careServiceRequest))),
                        HttpStatus.ACCEPTED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCareServiceById(@PathVariable("id") Long id) {

        Optional<CareService> careService = careServiceService.findCareServiceById(id);

        if (careService.isPresent()) {
            careServiceService.deleteCareServiceById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
