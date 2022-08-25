package com.db.except;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
	    System.out.println("4/3 = " + Division.divide(4, 3));
//        Main.divideWithoutTry();
        Main.divideWithTry();
        System.out.println("Another message");

        Set<Integer> integerSet = new TreeSet<>();
        integerSet.add(4);
        integerSet.add(4);
        integerSet.add(5);
        integerSet.add(6);

        Iterator<Integer> integerIterator = integerSet.iterator();
        while(integerIterator.hasNext()) {
            System.out.print(integerIterator.next() + ", ");
        }
    }

    private static void divideWithoutTry() {
        float division = Division.divide(4, 0);
        if (division == Float.MIN_VALUE) {
        } else {
            System.out.println("4/0 = " + division);
        }
    }

    private static void divideWithTry() {
        try {
            float division = Division.divideThrow(4, 0);
        } catch(ArithmeticException e){
            System.out.println("ArithmeticException (checked in main): " + e.getMessage());
        }
    }

}
