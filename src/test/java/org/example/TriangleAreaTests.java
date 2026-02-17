package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleAreaTests {

    private static final double DELTA = 0.0001;

    @Test
    public void byBaseAndHeight_shouldReturnCorrectArea_whenValidValues() {
        double result = TriangleArea.byBaseAndHeight(10, 5);
        Assert.assertEquals(result, 25.0, DELTA);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void byBaseAndHeight_shouldThrowException_whenBaseIsNegative() {
        TriangleArea.byBaseAndHeight(-10, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void byBaseAndHeight_shouldThrowException_whenHeightIsZero() {
        TriangleArea.byBaseAndHeight(10, 0);
    }

    @Test
    public void byTwoSidesAndAngle_shouldReturnCorrectArea_whenValidValues() {
        double result = TriangleArea.byTwoSidesAndAngle(10, 5, 90);
        Assert.assertEquals(result, 25.0, DELTA);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void byTwoSidesAndAngle_shouldThrowException_whenAngleIsInvalid() {
        TriangleArea.byTwoSidesAndAngle(10, 5, 180);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void byTwoSidesAndAngle_shouldThrowException_whenSideIsNegative() {
        TriangleArea.byTwoSidesAndAngle(-10, 5, 60);
    }

    @Test
    public void byThreeSides_shouldReturnCorrectArea_whenValidTriangle() {
        double result = TriangleArea.byThreeSides(3, 4, 5);
        Assert.assertEquals(result, 6.0, DELTA);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void byThreeSides_shouldThrowException_whenTriangleInequalityViolated() {
        TriangleArea.byThreeSides(1, 2, 3);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void byThreeSides_shouldThrowException_whenSideIsZero() {
        TriangleArea.byThreeSides(3, 4, 0);
    }
}
