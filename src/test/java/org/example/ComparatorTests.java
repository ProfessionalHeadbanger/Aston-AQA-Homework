package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ComparatorTests {
    @Test
    public void compare_shouldReturnOne_whenFirstNumberIsGreater() {
        int result = Comparator.compare(10, 5);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void compare_shouldReturnMinusOne_whenFirstNumberIsLess() {
        int result = Comparator.compare(5, 10);
        Assert.assertEquals(result, -1);
    }

    @Test
    public void compare_shouldReturnZero_whenNumbersAreEqual() {
        int result = Comparator.compare(7, 7);
        Assert.assertEquals(result, 0);
    }
}
