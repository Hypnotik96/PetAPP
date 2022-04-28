package com.tcc.petApp.careService;

import com.tcc.petApp.careService.api.CareServiceRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CareServiceMapper {

    public CareServiceRequest careServiceToCareServiceRequest(CareService careService) {
        return CareServiceRequest.builder()
                                 .name(careService.getName())
                                 .type(careService.getType())
                                 .range(careService.getRange())
                                 .description(careService.getDescription())
                                 .cost(careService.getCost())
                                 .build();
    }

    public CareService careServiceRequestToCareService(CareServiceRequest careServiceRequest) {
        return CareService.builder()
                          .name(careServiceRequest.getName())
                          .type(careServiceRequest.getType())
                          .range(careServiceRequest.getRange())
                          .description(careServiceRequest.getDescription())
                          .cost(careServiceRequest.getCost())
                          .build();
    }

    public CareService updateSetterCareService(CareService careService, CareServiceRequest careServiceRequest) {
        careService.setName(careServiceRequest.getName());
        careService.setType(careServiceRequest.getType());
        careService.setRange(careServiceRequest.getRange());
        careService.setDescription(careServiceRequest.getDescription());
        careService.setCost(careServiceRequest.getCost());
            return careService;
    }

    public List<CareServiceRequest> careServiceListToCareServiceRequestList(List<CareService> careServiceList) {

        List<CareServiceRequest> careServiceRequestList = new ArrayList<>();

            for (CareService careService:careServiceList) {
                careServiceRequestList.add(careServiceToCareServiceRequest(careService));
            }
        return careServiceRequestList;
    }

}
