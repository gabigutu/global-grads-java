package com.db.springhello.services;

import com.db.springhello.models.Customer;
import com.db.springhello.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomerById(int customerId) {
        Optional<Customer> customerOptional = this.customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            return customerOptional.get();
        }
        return null;
    }

}
