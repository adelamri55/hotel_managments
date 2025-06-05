package com.html.hotel.services;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.html.hotel.entities.Address;
import com.html.hotel.repositories.AddressRepository;


@Service
@Transactional
public class AddressService {


    @Autowired
    private AddressRepository addressRepository;


    public Address save(Address address) {
        return addressRepository.save(address);
    }


    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Unable to find address with id " + id));
    }


    public List<Address> findAll() {
        return addressRepository.findAll();
    }


    public Address update(Long id, Address addressUpdate) {
        Address foundAddress = findById(id);
        foundAddress.setStreet(addressUpdate.getStreet());
        foundAddress.setCity(addressUpdate.getCity());
        foundAddress.setCountry(addressUpdate.getCountry());
        foundAddress.setZipCode(addressUpdate.getZipCode());
        return save(foundAddress);
    }


    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }

    public long count() {
        return addressRepository.count();
    }
}

