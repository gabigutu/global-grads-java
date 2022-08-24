package com.db.except;

public class Division {

    static float divide(int a, int b) {
//        return a / (float)b; // Infinity?
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException (checked in division): " + e.getMessage());
            return Float.MIN_VALUE;
        }

    }

    static float divideThrow(int a, int b) throws ArithmeticException {
        return a / b;
    }

}
