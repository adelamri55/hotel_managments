package com.html.hotel.controllers.rest;

import java.util.List;

import com.html.hotel.entities.Address;
import com.html.hotel.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest-addresses")
public class AddressRestController {

    @Autowired
    private AddressService addressService;

    @PostMapping(value = "")

    public ResponseEntity<Address> create(@RequestBody Address address) {
        Address createdAddress = addressService.save(address);
        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Address> getById(@PathVariable("id") Long id) {
        Address foundAddress = addressService.findById(id);
        return new ResponseEntity<>(foundAddress, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Address>> getAll() {
        List<Address> foundAddress = addressService.findAll();
        return new ResponseEntity<>(foundAddress, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")

    public ResponseEntity<Address> update(@PathVariable("id") Long id, @RequestBody Address address) {
        Address updatedAddress = addressService.update(id, address);
        return new ResponseEntity<>(updatedAddress, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        addressService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

