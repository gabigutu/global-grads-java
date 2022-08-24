package com.db.except;

public class AgeException extends RuntimeException {

    public AgeException(int age, String name) {
        super("Person " + name + " has " + age + " yrs old");
    }
}
