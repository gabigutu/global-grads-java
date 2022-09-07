package com.db.springhello.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/product")
public class ProductController {
    @GetMapping("/{id}")
    public Object getProduct(@PathVariable(name = "id") Integer id) {
        return "{ 'Product id': " + id + "}";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable(name = "id") Integer id) {
        return "{product deleted}";
    }

    @PostMapping("/")
    public ResponseEntity postProduct() {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    public ResponseEntity putProduct() {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
