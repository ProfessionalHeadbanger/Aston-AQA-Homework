package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {
    @Test
    void add_shouldReturnCorrectResult_whenPositiveNumbers() {
        int result = Calculator.add(4, 6);
        assertEquals(10, result);
    }

    @Test
    void add_shouldReturnCorrectResult_whenNegativeNumbers() {
        int result = Calculator.add(-4, -6);
        assertEquals(-10, result);
    }

    @Test
    void subtract_shouldReturnCorrectResult_whenPositiveNumbers() {
        int result = Calculator.subtract(10, 4);
        assertEquals(6, result);
    }

    @Test
    void subtract_shouldReturnCorrectResult_whenNegativeNumbers() {
        int result = Calculator.subtract(-10, -4);
        assertEquals(-6, result);
    }

    @Test
    void multiply_shouldReturnCorrectResult_whenPositiveNumbers() {
        int result = Calculator.multiply(3, 5);
        assertEquals(15, result);
    }

    @Test
    void multiply_shouldReturnCorrectResult_whenNegativeNumbers() {
        int result = Calculator.multiply(-3, -5);
        assertEquals(15, result);
    }

    @Test
    void divide_shouldReturnCorrectResult_whenPositiveNumbers() {
        int result = Calculator.divide(12, 3);
        assertEquals(4, result);
    }

    @Test
    void divide_shouldReturnCorrectResult_whenNegativeNumbers() {
        int result = Calculator.divide(-12, -3);
        assertEquals(4, result);
    }

    @Test
    void divide_shouldThrowException_whenDividingByZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> Calculator.divide(10, 0)
        );

        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}
