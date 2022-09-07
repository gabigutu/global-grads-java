package com.db.springhello.controllers;

import com.db.springhello.services.LatLongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LatLongController {

    @Autowired
    private LatLongService latLongService;

    @GetMapping("/geocoder/{lat}/{long}")
    public String getCity(@PathVariable(name = "lat") Float latitude, @PathVariable(name = "long") Float longitude) {
        return this.latLongService.getCityName(latitude, longitude);
    }

}
