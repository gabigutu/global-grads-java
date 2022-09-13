package com.db.springhello.exceptions;

public class LatitudeException extends Exception {

    public LatitudeException(float latitude) {
        super("Unaccepted latitude value: " + latitude);
    }
}
