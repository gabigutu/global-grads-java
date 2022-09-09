package com.db.springhello.controllers;

import com.db.springhello.models.City;
import com.db.springhello.services.LatLongService;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class LatLongController {

    @Autowired
    private LatLongService latLongService;

    @GetMapping("/geocoder/{lat}/{long}")
    public ModelAndView ResponseEntitygetCity(
            @PathVariable(name = "lat") Float latitude,
            @PathVariable(name = "long") Float longitude,
            @CookieValue(name = "yourcity", defaultValue = "Unknown") String cookieCityName,
            HttpServletResponse response) {
        String cityName = this.latLongService.getCityName(latitude, longitude);
        ModelAndView modelAndView = new ModelAndView("latlong");
        modelAndView.addObject("city", cityName);
        City[] cities = this.latLongService.getCitiesAsArray();
        modelAndView.addObject("cities", cities);

        if (cookieCityName.length() > 0 && cookieCityName.compareTo("Unknown") != 0) {
            System.out.println("A request with a city name in cookie arrived: city name = " + cookieCityName);
        } else {
            ResponseCookie springCookie = ResponseCookie.from("yourcity", cityName)
                    .httpOnly(true)
                    .secure(true)
                    .path("/")
                    .maxAge(60)
                    .domain("localhost")
                    .build();
            response.addHeader(HttpHeaders.SET_COOKIE, springCookie.toString());
        }

        return modelAndView;
    }

}
