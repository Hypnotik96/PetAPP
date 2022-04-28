package com.tcc.petApp.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> findAddressById(Long id) {
        return addressRepository.findById(id);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }
}
