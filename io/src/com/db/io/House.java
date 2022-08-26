package com.db.io;

import java.io.Serializable;

public class House implements Serializable {

    private String name;
    private float lat;
    private float _long;

    public House(String name) {
        this.name = name;
    }

    public void set_long(float _long) {
        this._long = _long;
    }

    public float get_long() {
        return _long;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLat() {
        return lat;
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", lat=" + lat +
                ", _long=" + _long +
                '}';
    }
}
