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
//        Customer customer = this.customerRepository.getReferenceById(customerId);
        Customer customer = this.customerRepository.findById(customerId).get();
        System.out.println("Customer " + customer.id);
        return customer;
    }

    public Customer insertCustomer(Customer customer) {
        customer = this.customerRepository.saveAndFlush(customer);
        System.out.println("Saved new customer with id: " + customer.id);
        return customer;
    }

}
