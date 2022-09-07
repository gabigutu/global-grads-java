package com.db.springhello.controllers;

import com.db.springhello.models.Customer;
import com.db.springhello.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{id}")
    public Object getCustomer(@PathVariable(name = "id") Integer id) {
        Customer customer = this.customerService.getCustomerById(id);
        return customer;
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable(name = "id") Integer id) {
        return "{}";
    }

    @PostMapping("/")
    public ResponseEntity postCustomer() {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    public ResponseEntity putCustomer() {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
