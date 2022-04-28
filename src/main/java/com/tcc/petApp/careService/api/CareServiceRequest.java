package com.tcc.petApp.careService.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CareServiceRequest {

    private String name;
    private String type;
    private Byte range;
    private String description;
    private double cost;
}
