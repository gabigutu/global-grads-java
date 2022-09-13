package com.db.springhello.controllers;

import com.db.springhello.exceptions.LatitudeException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ExceptionHandlerController {

    @ExceptionHandler(LatitudeException.class)
    public void latitudeHandler() {
        System.err.println("Latitude is not fine");
    }
}
