package com.tcc.petApp.address;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends Repository<Address, Long> {

    public List<Address> findAll();
    public Optional<Address> findById(Long id);
    public Address save(Address address);
    public void deleteById(Long id);
}
