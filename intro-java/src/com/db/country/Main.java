package com.db.country;

import com.db.person.Person;
import com.db.person.Student;

public class Main {

    public static void main(String[] args){
        System.out.println("Hello, world!");

//        String myStr = "Hello";
//        com.db.person.Person person = new com.db.person.Person();
//        System.out.println("com.db.person.Person is : " + person);

        int a = 4;
        boolean isTrue = false;
//        float height = (float)3.141592653589793;
//        double height = 3.141592653589793;
        double height = 3.1415926535897939719371927391739127376126127635127635;
        System.out.println("Height is: " + height);

        long b = 123671263812763127l;

        double c = 3;

        System.out.println(4 + 5);
        System.out.println(4 + -5);
        System.out.println(4 - 5);

        int d = 3;
        System.out.println(d++); // 3
        System.out.println(++d); // 5
        System.out.println(d); // 5

        d -= 2; // d = d - 2;
        System.out.println(d); // 3

        System.out.println(d >= 3);
        System.out.println(!(d >= 3));

        // operatori logici (de scurtcircuitare)
        boolean isTrue1 = false;
//        System.out.println(isTrue1 && ((boolean) (d = 4)));

        // 101 (5)
        // 100 (4)
        int x = 5;
        int y = 4;
        System.out.println(x & y);
        // 100

        // 101 << 2 => 10100;
        System.out.println(5  << 2);

        // 101 >> 1 => 10 (2)

        final int INSTALL_OS = 1; // ?
        final int INSTALL_DRIVERS = 2;
        final int INSTALL_OFFICE = 3;

        int whatToInstall = INSTALL_OS;

        switch(whatToInstall) {
            case INSTALL_OS:
                System.out.println("Install OS");
            case INSTALL_DRIVERS:
                System.out.println("Install drivers");
                break;
            case INSTALL_OFFICE:
                System.out.println("Install office");
                break;
        }

        for (int i = 0; i < 10; i++) {

        }

//        for (;;) {
//            // ?
//        }

        boolean stopMe = false;
        for (System.out.println("only once");!stopMe; System.out.println("Hello"), System.out.println("Bye")) {
            // ?
            System.out.println("Continuing");
            if (Math.random() < 0.5) {
                stopMe = !stopMe;
            }

        }

        long[] myNumbers = new long[10];
        int noOfNumbers = 0;
        while(noOfNumbers < 5) {
            myNumbers[noOfNumbers++] = (long) (Math.random() * 1231312313313131l); // [0; 1)
        }

        // 0.63515313 * 1231312313313131

        for (int i = 0; i < noOfNumbers; i++) {
            System.out.print(myNumbers[i] + " ");
        }
        System.out.println(); // \n


        Person person1 = new Person("Vasile");
        System.out.println("com.db.person.Person: " + person1);
        System.out.println("Is sleeping? " + person1.isSleeping());
        person1.goToSleep();
        System.out.println("Is sleeping? " + person1.isSleeping());

        System.out.println("No persons: " + Person.NO_PERSONS);

        Person person2 = new Person("Gigel");
        System.out.println("No persons: " + Person.NO_PERSONS);
        Person.showNoOfPersons();

        Student student1 = new Student("Popescu");
//        com.db.person.Student student2 = new com.db.person.Student();
        System.out.println("is student sleeping? " + student1.isSleeping());
        student1.setSleeping(true);
        System.out.println("is student sleeping? " + student1.isSleeping());
        System.out.println("com.db.person.Student info: " + student1.toString());
        student1.setGrade(7.2f);
        System.out.println("com.db.person.Student grade: " + student1.getGrade());
        System.out.println("com.db.person.Student info: " + student1);

        System.out.println("com.db.person.Student name: " + student1.getHeight());
    }
}
