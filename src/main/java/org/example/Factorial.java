package org.example;

public class Factorial {
    public static int calculate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }

        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }

        return result;
    }
}
