package com.tcc.petApp.contract.api;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
public class ContractRequest {

    @NotNull
    private LocalDateTime when;

    @NotNull
    private String petName;

    @NotNull
    private Long careServiceId;

    @NotNull
    private Long petOwnerId;
}
