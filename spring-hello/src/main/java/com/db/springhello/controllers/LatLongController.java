package com.db.springhello.controllers;

import com.db.springhello.exceptions.LatitudeException;
import com.db.springhello.lambda.AnimalAction;
import com.db.springhello.lambda.AnimalCry;
import com.db.springhello.lambda.AnimalSound;
import com.db.springhello.lambda.Summer;
import com.db.springhello.models.City;
import com.db.springhello.services.LatLongService;
import io.swagger.annotations.ApiOperation;
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
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Controller
@RequestMapping("/api")
public class LatLongController {

    @Autowired
    private LatLongService latLongService;

    @ApiOperation(value = "Calculates city out of latitude and longitude")
    @GetMapping("/geocoder/{lat}/{long}")
    public ModelAndView ResponseEntitygetCity(
            @PathVariable(name = "lat") Float latitude,
            @PathVariable(name = "long") Float longitude,
            @CookieValue(name = "yourcity", defaultValue = "Unknown") String cookieCityName,
            HttpServletResponse response) throws LatitudeException {
        if (latitude < 0) {
            throw new LatitudeException(latitude);
        }
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

        lambdaTest();
        return modelAndView;
    }

    void lambdaTest() {
        AnimalSound animalSound = (ceva) -> "Animal makes the sound " + ceva;
        System.out.println(animalSound.makeSound("bark"));

        animalSound = (ceva) -> {
            System.out.println("Sunt in lambda-ul creat");
            // ..
            return "Animal makes the sound " + ceva;
        };
        System.out.println(animalSound.makeSound("woof"));

        AnimalAction animalAction = (actionName, actionTime) -> "Animal makes the action " + actionName + " for " + actionTime + "seconds";
        System.out.println(animalAction.action("walk", 5));
        System.out.println(animalAction.action("sleep", 10));

        Summer summer = (x, y) -> x + y;
        System.out.println(summer.sum(3, 9));

        animalSound = (x) -> x.toLowerCase();
        System.out.println(animalSound.makeSound("WOOF")); // converts string to lower case

        AnimalCry tiger = (sound) -> "Tiger " + sound;
        tiger.cry("waaaa");
        AnimalCry cat = (sound) -> "Cat " + sound;
        cat.cry("miau");

        Object object = new Object();
        Predicate myPredicate = (x) -> true;
        myPredicate.test(object);

        Predicate<City> westHemisphere = (x) -> {
            if (x._long < 0) {
                return true;
            }
            return false;
        };
        System.out.println("Brazilia: " + westHemisphere.test(new City(10, -20, "Brazilia")));
        System.out.println("Romania: " + westHemisphere.test(new City(10, 20, "Romania")));

        Consumer<City> cityDestroyer = (x) -> {
            System.out.println("Destroying city " + x);
            return;
        };
        cityDestroyer.accept(new City(20, 40, "Rusia"));
    }

    @ExceptionHandler(LatitudeException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Latitude cannot be negative")
    public void latitudeHandler(Exception ex) {
        System.err.println("Latitude is not fine: " + ex.getMessage());
    }

}
