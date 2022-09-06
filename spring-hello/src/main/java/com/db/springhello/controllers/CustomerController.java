package com.db.springhello.controllers;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/customer")
public class CustomerController {

    @GetMapping("/{id}")
    public Object getCustomer(@PathVariable(name = "id") Integer id) {
        return "{ 'id': " + id + "}";
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable(name = "id") Integer id) {
        return "{}";
    }

}
