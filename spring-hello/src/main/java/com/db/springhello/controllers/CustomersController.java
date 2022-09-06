package com.db.springhello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private ServerProperties serverProperties;

    @GetMapping("")
    public Object getCustomers() {
        return "{BUN}";
    }

    @GetMapping("/")
    public ResponseEntity getCustomersSlash(HttpServletRequest request) {
        RequestMapping requestMappingAnnotation = this.getClass().getAnnotation(RequestMapping.class);
//        String url = "http://localhost:" + serverProperties.getPort() + Arrays.toString(requestMappingAnnotation.path());
        String url = request.getServletPath().replaceAll("/$", "");
        System.out.println("URL = " + url);
        try {
            return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(new URI(url)).build();
        } catch (URISyntaxException e) {
            System.err.println("Cannot redirect to " + url);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        this.getCustomers();
        // nu e nimeni la /, du-te la fara slash
    }

}
