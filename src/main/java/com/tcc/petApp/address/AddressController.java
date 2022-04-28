package com.tcc.petApp.address;

import com.tcc.petApp.address.api.AddressRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @Autowired
    AddressMapper addressMapper;

    // ADDRESS LIST
    @GetMapping
    public ResponseEntity<List<Address>> findAllAddresses() {
       return new ResponseEntity<List<Address>>(addressService.findAllAddresses(), HttpStatus.OK);
    }

    // ADDRESS REQUEST LIST
    /*
    @GetMapping
    public ResponseEntity<List<AddressRequest>> findAllAddresses() {
        List<Address> addressList = address.Service.findAllAddress;
        return new ResponseEntity<List<AddressRequest>>(addressMapper.addressListToAddressRequestList(addressList),
        HttpStatus.OK);
    }
    */

    @GetMapping("/{id}")
    public ResponseEntity<AddressRequest> findAddressById(@PathVariable("id") Long id) {

        Optional<Address> address = addressService.findAddressById(id);

        return address.map(value -> new ResponseEntity<AddressRequest>(addressMapper.addressToAddressRequest(value),
                        HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<AddressRequest> saveAddress(@RequestBody AddressRequest addressRequest) {

        Address address = addressMapper.addressRequestToAddress(addressRequest);
        addressService.saveAddress(address);

        return new ResponseEntity<AddressRequest>(addressRequest, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressRequest> updateAddress(@PathVariable("id") Long id,
                                                        @RequestBody AddressRequest addressRequest) {

        Optional<Address> addressToUpdade = addressService.findAddressById(id);

        return addressToUpdade.map(address -> new ResponseEntity<AddressRequest>
                              (addressMapper.addressToAddressRequest(
                                      addressService.updateAddress(
                                              addressMapper.updateSetterAddress(address ,addressRequest))),
                                      HttpStatus.ACCEPTED))
                              .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddressById(@PathVariable("id") Long id) {

        Optional<Address> address = addressService.findAddressById(id);

        if(address.isPresent()) {
            addressService.deleteAddressById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}
