package com.db.springhello.controllers;

import com.db.springhello.models.Customer;
import com.db.springhello.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;

@RestController()
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable(name = "id") Integer id) {
        Customer customer = this.customerService.getCustomerById(id);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable(name = "id") Integer id) {
        return "{}";
    }

    @PostMapping("")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
        customer.id = 0;
//        if (customer.firstName == "")
        System.out.println("Trying to create customer: " + customer.id);
        customer = this.customerService.insertCustomer(customer);
        // TODO: get inserted customer (with new id)
        // TODO: return view (with thymeleaf)
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity putCustomer() {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
