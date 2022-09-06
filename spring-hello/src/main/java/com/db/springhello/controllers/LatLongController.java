package com.db.springhello.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LatLongController {

    @GetMapping("/geocoder/{lat}/{long}")
    public String getCity(@PathVariable(name = "lat") Float latitude, @PathVariable(name = "long") Float longitude) {
        return "{OK}";
    }

}
