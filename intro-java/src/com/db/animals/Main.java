package com.db.animals;

public class Main {

    public static void main(String args[]) {
        Pig pig = new Pig(); // Pig pig = new Animal();
        pig.animalSound();

        Dog dog = new Dog();
        dog.animalSound();
        ((Animal)dog).lives();

//        Animal animal = new Animal();
//        animal.animalSound();

        Animal dirtyPig = new Pig();
        dirtyPig.animalSound();
        if (dirtyPig instanceof Pig) {
            ((Pig) dirtyPig).playsInDirt();
        } else {
            System.err.println("Pig cannot be cast to pig");
        }

        Animal dirtyDog = new Dog();
        dirtyDog.animalSound();
        if (dirtyDog instanceof Pig) {
            ((Pig)dirtyDog).playsInDirt();
        } else {
            System.err.println("Dog cannot be cast to pig");
        }

    }


}

abstract class Animal implements Being {
    public void animalSound() {
        System.out.println("The animal makes a sound");
    }

    public void lives() {
        System.out.println("Animal is alive");
    }

    public abstract void lives(int miliseconds);
}

class Pig extends Animal {
    
    @Override
    public void animalSound() {
        System.out.println("The pig says: wee wee");
    }

    @Override
    public void lives(int miliseconds) {

    }

    public void playsInDirt() {
        System.out.println("The pig plays in dirt");
    }
}

class Dog extends Animal {

    @Override
    public void animalSound() {
        System.out.println("The dog says: bow wow");
    }

    @Override
    public void lives(int miliseconds) {

    }
}

class Plant implements Being {

    @Override
    public void lives() {

    }

    @Override
    public void lives(int miliseconds) {

    }
}

interface Being {
    void lives();
    void lives(int miliseconds);
}