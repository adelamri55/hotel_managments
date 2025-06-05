package com.html.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.html.hotel.entities.Customer;
import com.html.hotel.repositories.CustomerRepository;


@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Unable to find customer with id " + id));
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer update(Long id, Customer customerUpdate) {
        Customer foundCustomer = findById(id);
        foundCustomer.setFirstName(customerUpdate.getFirstName());
        foundCustomer.setLastName(customerUpdate.getLastName());
        foundCustomer.setEmail(customerUpdate.getEmail());
        foundCustomer.setPhoneNumber(customerUpdate.getPhoneNumber());
        foundCustomer.setAddress(customerUpdate.getAddress());
        return save(foundCustomer);
    }

    public void deleteById(Long id) { customerRepository.deleteById(id); }

    public long count() {
        return customerRepository.count();
    }
}

