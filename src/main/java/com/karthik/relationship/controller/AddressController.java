package com.karthik.relationship.controller;

import com.karthik.relationship.model.Address;
import com.karthik.relationship.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
@CrossOrigin(origins = "*")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Long id) {
        return new ResponseEntity<>(addressService.getAddress(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAllAddress() {
        return new ResponseEntity<>(addressService.findAll(),HttpStatus.OK);
    }
}
