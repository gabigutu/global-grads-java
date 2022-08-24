package com.db.intern;

public class Main {

    public static void main(String[] args) {

        Person person1 = new Person();
        Person.Head headPerson1 = person1.new Head();
        headPerson1.speak();

        person1.setSleeping(true);
        headPerson1.speak();

//        Person.NO_PERSONS
        Person.Planet.show();



    }
}
