package com.db.except;

import java.io.IOException;
import java.util.Arrays;

public class Club {

    private int minAge;
    private Person[] people;
    private int noPeople;

    public Club(int minAge) {
        this.minAge = minAge;
        people = new Person[100];
        noPeople = 0;
    }

    public void join(Person person) throws Exception { // throws Exception TODO
        if (person.getAge() < 0) {
            throw new IOException("Age cannot be negative");
        }
        if (person.getAge() < this.minAge) {
            throw new AgeException(person.getAge(), person.getName());
        }
        System.out.println("Current no of people: " + noPeople);
        people[noPeople++] = person;
    }

    public static void main(String args[]) {
        Club club = new Club(18);
        try {
            club.join(club.new Person("Vasile", -17));
            System.out.println("Club: " + club);
        } catch(AgeException e) {
            System.out.println("AgeException: " + e.getMessage());
        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Other exception: " + e.getMessage());
        }

//        try {
//            club.join(club.new Person("Gigel", 17));
//            System.out.println("Club: " + club);
//        } catch(AgeException e) {
//            System.out.println("AgeException: " + e.getMessage());
//        }
//        try {
//            club.join(club.new Person("Popescu", 23));
//            System.out.println("Club: " + club);
//        } catch(AgeException e) {
//            System.out.println("AgeException: " + e.getMessage());
//        }

//        finally {
//            System.out.println("S-au verificat toate persoanele");
//        }
    }

    class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Club{" +
                "people=" + Arrays.toString(people) +
                ", noPeople=" + noPeople +
                '}';
    }
}

