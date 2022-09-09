package com.db.springhello.models;

public class City {

    public float lat;
    public float _long;
    public String cityName;

    public City(float lat, float _long, String cityName) {
        this.lat = lat;
        this._long = _long;
        this.cityName = cityName;
    }

}
