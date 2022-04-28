package com.tcc.petApp.address;


import com.tcc.petApp.address.api.AddressRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressMapper {

    public AddressRequest addressToAddressRequest(Address address) {
        return AddressRequest.builder()
                .street(address.getStreet())
                .number(address.getNumber())
                .postalCode(address.getPostalCode())
                .city(address.getCity())
                .state(address.getState())
                .complement(address.getComplement())
                .build();
    }

    public Address addressRequestToAddress(AddressRequest addressRequest) {
        return Address.builder()
                .street(addressRequest.getStreet())
                .number(addressRequest.getNumber())
                .postalCode(addressRequest.getPostalCode())
                .city(addressRequest.getCity())
                .state(addressRequest.getState())
                .complement(addressRequest.getComplement())
                .build();
    }

    public Address updateSetterAddress(Address address, AddressRequest addressRequest) {
        address.setStreet(addressRequest.getStreet());
        address.setStreet(addressRequest.getStreet());
        address.setNumber(addressRequest.getNumber());
        address.setPostalCode(addressRequest.getPostalCode());
        address.setCity(addressRequest.getCity());
        address.setState(addressRequest.getState());
        address.setComplement(addressRequest.getComplement());
               return address;
    }

    public List<AddressRequest> addressListToAddressRequestList (List<Address> addressList){
        List<AddressRequest> addressRequestList = new ArrayList<>();
        for (Address address:addressList) {
            addressRequestList.add(addressToAddressRequest(address));
        }
        return addressRequestList;
    }
}
