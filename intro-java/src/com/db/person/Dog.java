package com.db.person;

public class Dog extends Creature {

    @Override
    public void goToSleep() {
        System.out.println("Dog is going to sleep");
    }

    @Override
    public boolean isSleeping() {
        return false;
    }
}
