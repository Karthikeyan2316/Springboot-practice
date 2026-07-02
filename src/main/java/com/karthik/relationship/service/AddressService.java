package com.karthik.relationship.service;

import com.karthik.relationship.exception.StudentNotFound;
import com.karthik.relationship.model.Address;
import com.karthik.relationship.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    public Address getAddress(Long id) {
        return addressRepository.findById(id).orElseThrow(()->new StudentNotFound("Address not found for " + id));
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }
}
