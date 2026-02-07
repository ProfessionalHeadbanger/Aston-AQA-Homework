package org.example;

import org.example.my_exceptions.MyArrayDataException;
import org.example.my_exceptions.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "a", "11", "12"},
                {"13", "14", "15", "16"},
                //{"17", "18", "19", "20"}
        };

        try {
            int result = sumArray(array);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных массива: " + e.getMessage());
        }

        generateArrayIndexException();
    }

    final static int ARRAY_SIZE = 4;

    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != ARRAY_SIZE) {
            throw new MyArraySizeException("Массив должен быть размером " + ARRAY_SIZE + "x" + ARRAY_SIZE);
        }

        for (int index = 0; index < array.length; index++) {
            if (array[index].length != ARRAY_SIZE) {
                throw new MyArraySizeException("Массив должен быть размером " + ARRAY_SIZE + "x" + ARRAY_SIZE);
            }
        }

        int sum = 0;

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                try {
                    sum += Integer.parseInt(array[row][col]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(row, col);
                }
            }
        }

        return sum;
    }

    public static void generateArrayIndexException() {
        try {
            int[] arr = new int[3];
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
