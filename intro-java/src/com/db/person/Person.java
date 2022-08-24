package com.db.person;

public class Person extends Creature {

    protected String name;
    private int age;
    protected float height;
    private boolean isSleeping;
    public static long NO_PERSONS = 0;

    public Person() {
        System.out.println("Inside no params com.db.person.Person constructor");
    }

    public Person(String name) { // constructor
        System.out.println("Inside com.db.person.Person constructor");
        this.name = name;
        this.isSleeping = false;
        Person.NO_PERSONS++;
    }

    public void goToSleep() { // behaviour
        // shut eyes
        isSleeping = true;
    }

    void wakeUp() {
        isSleeping = false;
    }

    public boolean isSleeping() {
        return isSleeping;
    }

    public void setSleeping(boolean isSleeping) {
        this.isSleeping = isSleeping;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public static void showNoOfPersons() {
        System.out.println("No. of persons is " + NO_PERSONS);
    }

}
