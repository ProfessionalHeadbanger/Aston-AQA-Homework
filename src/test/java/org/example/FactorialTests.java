package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTests {
    @Test
    public void calculate_shouldReturnCorrectResult_whenPositiveNumber() {
        int result = Factorial.calculate(5);
        Assert.assertEquals(result, 120);
    }

    @Test
    public void calculate_shouldReturnCorrectResult_whenNumberIsOne() {
        int result = Factorial.calculate(1);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void calculate_shouldReturnCorrectResult_whenNumberIsZero() {
        int result = Factorial.calculate(0);
        Assert.assertEquals(result, 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void calculate_shouldThrowException_whenNumberIsNegative() {
        Factorial.calculate(-5);
    }
}
