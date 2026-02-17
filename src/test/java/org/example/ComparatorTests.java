package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComparatorTests {
    @Test
    void compare_shouldReturnOne_whenFirstNumberIsGreater() {
        int result = Comparator.compare(10, 5);
        assertEquals(1, result);
    }

    @Test
    void compare_shouldReturnMinusOne_whenFirstNumberIsLess() {
        int result = Comparator.compare(5, 10);
        assertEquals(-1, result);
    }

    @Test
    void compare_shouldReturnZero_whenNumbersAreEqual() {
        int result = Comparator.compare(7, 7);
        assertEquals(0, result);
    }
}
