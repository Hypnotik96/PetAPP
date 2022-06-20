package com.tcc.petApp.careService.api;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class CareServiceRequest {
    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private String petName;

    @NotNull
    private Byte range;

    private String description;

    @NotNull
    private double cost;
}
