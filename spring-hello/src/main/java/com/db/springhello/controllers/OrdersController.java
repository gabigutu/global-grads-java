package com.db.springhello.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    @Autowired
    private ServerProperties serverProperties;

    @GetMapping("")
    public Object getOrders() {
        return "{BUN}";
    }

    @GetMapping("/")
    public ResponseEntity getOrdersSlash(HttpServletRequest request) {
        RequestMapping requestMappingAnnotation = this.getClass().getAnnotation(RequestMapping.class);

        String url = request.getServletPath().replaceAll("/$", "");
        System.out.println("URL = " + url);
        try {
            return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(new URI(url)).build();
        } catch (URISyntaxException e) {
            System.err.println("Cannot redirect to " + url);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
