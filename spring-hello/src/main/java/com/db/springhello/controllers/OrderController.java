package com.db.springhello.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @GetMapping("/{id}")
    public Object getOrder(@PathVariable(name = "id") Integer id) {
        return "{ 'Order id': " + id + "}";
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable(name = "id") Integer id) {
        return "{order deleted}";
    }

    @PostMapping("/")
    public ResponseEntity postOrder() {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    public ResponseEntity putOrder() {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
