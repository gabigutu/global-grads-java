package com.db.springhello.services;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.*;

@Service()
public class LatLongService {

    private int noCities;
    private Map<Pair<Float, Float>, String> cities;

    public LatLongService() {
        cities = new HashMap<>();
        this.noCities = 100;
        this.setCities();
        this.printCities();
    }

    public String getCityName(float lat, float _long) {
        return cities.get(new ImmutablePair<>(lat, _long));
    }

    private void setCities() {
        float lat = 22.3f;
        float _long = 44.8f;
        String cityName = generateRandomString();
        cities.put(new ImmutablePair<>(lat, _long), cityName);

        for (int i = 1; i < this.noCities; i++) {
            lat = (float)(Math.random() * 20);
            _long = Math.random() < 0.5 ? -(float)(Math.random() * 90): (float)(Math.random() * 90);
            cityName = generateRandomString();
            cities.put(new ImmutablePair<>(lat, _long), cityName);
        }

//        Float f = new Float();
//        f = (float)2.3;
    }

    private void printCities() {
        System.out.println("=== Cities ===");
//        Set<String> mySet = new HashSet<>();
//        mySet.add("Test");
//        for (String str : mySet) {}
        for (Map.Entry<Pair<Float, Float>, String> city : cities.entrySet()) {
            float lat = city.getKey().getLeft();
            float _long = city.getKey().getRight();
            String cityName = city.getValue();
            System.out.println(cityName + " (" + lat + ", " + _long + ")");
        }
    }

    private String generateRandomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("ASCII"));
        return generatedString;
    }

}
