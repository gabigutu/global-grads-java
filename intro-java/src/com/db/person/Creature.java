package com.db.person;

public abstract class Creature {

    public abstract void goToSleep();
//    public abstract void goToSleep(long miliseconds);
//    public abstract void goToSleep(double miliseconds);
    public abstract boolean isSleeping();

    public void isBreathing() {
        System.out.println("Creature is breathing");
    }

}
