package com.tcc.petApp.address.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressRequest {

    private String street;
    private Integer number;
    private String postalCode;
    private String city;
    private String state;
    private String complement;
}
