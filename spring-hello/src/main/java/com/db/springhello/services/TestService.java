package com.db.springhello.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@Profile("!test")
public class TestService {

    public void init() {
        System.err.println("Test service initialized");
    }

}
