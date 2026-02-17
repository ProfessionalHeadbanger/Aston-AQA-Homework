package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTests {
    @Test
    void calculate_shouldReturnCorrectResult_whenPositiveNumber() {
        int result = Factorial.calculate(5);
        assertEquals(120, result);
    }

    @Test
    void calculate_shouldReturnCorrectResult_whenNumberIsOne() {
        int result = Factorial.calculate(1);
        assertEquals(1, result);
    }

    @Test
    void calculate_shouldReturnCorrectResult_whenNumberIsZero() {
        int result = Factorial.calculate(0);
        assertEquals(1, result);
    }

    @Test
    void calculate_shouldThrowException_whenNumberIsNegative() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Factorial.calculate(-5)
        );

        assertEquals(
                "Factorial is not defined for negative numbers",
                exception.getMessage()
        );
    }
}
