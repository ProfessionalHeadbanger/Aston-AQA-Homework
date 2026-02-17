package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTests {
    @Test
    public void add_shouldReturnCorrectResult_whenPositiveNumbers() {
        int result = Calculator.add(4, 6);
        Assert.assertEquals(result, 10);
    }

    @Test
    public void add_shouldReturnCorrectResult_whenNegativeNumbers() {
        int result = Calculator.add(-4, -6);
        Assert.assertEquals(result, -10);
    }

    @Test
    public void subtract_shouldReturnCorrectResult_whenPositiveNumbers() {
        int result = Calculator.subtract(10, 4);
        Assert.assertEquals(result, 6);
    }

    @Test
    public void subtract_shouldReturnCorrectResult_whenNegativeNumbers() {
        int result = Calculator.subtract(-10, -4);
        Assert.assertEquals(result, -6);
    }

    @Test
    public void multiply_shouldReturnCorrectResult_whenPositiveNumbers() {
        int result = Calculator.multiply(3, 5);
        Assert.assertEquals(result, 15);
    }

    @Test
    public void multiply_shouldReturnCorrectResult_whenNegativeNumbers() {
        int result = Calculator.multiply(-3, -5);
        Assert.assertEquals(result, 15);
    }

    @Test
    public void divide_shouldReturnCorrectResult_whenPositiveNumbers() {
        int result = Calculator.divide(12, 3);
        Assert.assertEquals(result, 4);
    }

    @Test
    public void divide_shouldReturnCorrectResult_whenNegativeNumbers() {
        int result = Calculator.divide(-12, -3);
        Assert.assertEquals(result, 4);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divide_shouldThrowException_whenDividingByZero() {
        Calculator.divide(10, 0);
    }
}
