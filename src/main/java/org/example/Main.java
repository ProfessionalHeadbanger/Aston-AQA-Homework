package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("1.");
        printThreeWords();

        System.out.println("\n2.");
        checkSumSign();

        System.out.println("\n3.");
        printColor();

        System.out.println("\n4.");
        compareNumbers();

        System.out.println("\n5.");
        int first = 11;
        int second = 2;
        if (checkBoundaries(first, second)) {
            System.out.println(first + " + " + second + " ∈ [10, 20]");
        } else {
            System.out.println(first + " + " + second + " ∉ [10, 20]");
        }

        System.out.println("\n6.");
        int numberToCheck = -1;
        checkNumberSign(numberToCheck);

        System.out.println("\n7.");
        int number = 1;
        if (isNegativeNumber(number)) {
            System.out.println("Число " + number + " - отрицательное");
        } else {
            System.out.println("Число " + number + " - положительное");
        }

        System.out.println("\n8.");
        String stringToPrint = "This string should be printed";
        int times = 3;
        printStringNTimes(stringToPrint, times);

        System.out.println("\n9.");
        int year = 1900;
        if (isLeapYear(year)) {
            System.out.println(year + " - високосный");
        } else {
            System.out.println(year + " - невисокосный");
        }

        System.out.println("\n10.");
        changeElements();
        System.out.println();

        System.out.println("\n11.");
        makeAndFillArray();
        System.out.println();

        System.out.println("\n12.");
        multiplyByCondition();
        System.out.println();

        System.out.println("\n13.");
        makeDoubleDiagonalMatrix();

        System.out.println("\n14.");
        int len = 10;
        int initialValue = 10;
        int[] array = makeArray(len, initialValue);
        for (int index = 0; index < len; index++) {
            System.out.print(array[index] + " ");
        }
    }

    private static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    private static void checkSumSign() {
        int a = 12;
        int b = -13;
        if (a + b > 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    private static void printColor() {
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 & value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    private static void compareNumbers() {
        int a = 30;
        int b = 50;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    private static boolean checkBoundaries(int first, int second) {
        int sum = first + second;
        return sum >= 10 & sum <= 20;
    }

    private static void checkNumberSign(int number) {
        if (number < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    private static boolean isNegativeNumber(int number) {
        return number < 0;
    }

    private static void printStringNTimes(String string, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(string);
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 & year % 100 != 0) | year % 400 == 0;
    }

    private static void changeElements() {
        int[] arrayOf1and0 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int index = 0; index < arrayOf1and0.length; index++) {
            if (arrayOf1and0[index] == 1) {
                arrayOf1and0[index] = 0;
            } else {
                arrayOf1and0[index] = 1;
            }
            System.out.print(arrayOf1and0[index] + " ");
        }
    }

    private static void makeAndFillArray() {
        int[] arrayWith100Length = new int[100];
        for (int index = 0; index < arrayWith100Length.length; index++) {
            arrayWith100Length[index] = index + 1;
            System.out.print(arrayWith100Length[index] + " ");
        }
    }

    private static void multiplyByCondition() {
        int[] arrayOfNumbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int index = 0; index < arrayOfNumbers.length; index++) {
            if (arrayOfNumbers[index] < 6) {
                arrayOfNumbers[index] *= 2;
            }
            System.out.print(arrayOfNumbers[index] + " ");
        }
    }

    private static void makeDoubleDiagonalMatrix() {
        int size = 9;
        int[][] squareMatrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == col) {
                    squareMatrix[row][col] = 1;
                } else if (row + col + 1 == size) {
                    squareMatrix[row][col] = 1;
                }
                System.out.print(squareMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[] makeArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }
}