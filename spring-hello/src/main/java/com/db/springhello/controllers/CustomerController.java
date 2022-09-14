package com.db.springhello.controllers;

import com.db.springhello.models.Customer;
import com.db.springhello.repository.CustomerRepository;
import com.db.springhello.services.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        this.customerService.deleteCustomerById(id);
        return "{}";
    }

    @PostMapping("")
    @ApiOperation(consumes = "application/json", value = "Post Customer")
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
    @ApiOperation(consumes = "application/json, application/xml", value = "Put Customer")
    public ResponseEntity putCustomer() {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
