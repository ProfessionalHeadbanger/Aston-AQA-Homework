package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaTests {
    private static final double DELTA = 0.0001;

    @Test
    void byBaseAndHeight_shouldReturnCorrectArea_whenValidValues() {
        double result = TriangleArea.byBaseAndHeight(10, 5);
        assertEquals(25.0, result, DELTA);
    }

    @Test
    void byBaseAndHeight_shouldThrowException_whenBaseIsNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.byBaseAndHeight(-10, 5));
    }

    @Test
    void byBaseAndHeight_shouldThrowException_whenHeightIsZero() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.byBaseAndHeight(10, 0));
    }

    @Test
    void byTwoSidesAndAngle_shouldReturnCorrectArea_whenValidValues() {
        double result = TriangleArea.byTwoSidesAndAngle(10, 5, 90);
        assertEquals(25.0, result, DELTA);
    }

    @Test
    void byTwoSidesAndAngle_shouldThrowException_whenAngleIsInvalid() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.byTwoSidesAndAngle(10, 5, 180));
    }

    @Test
    void byTwoSidesAndAngle_shouldThrowException_whenSideIsNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.byTwoSidesAndAngle(-10, 5, 60));
    }

    @Test
    void byThreeSides_shouldReturnCorrectArea_whenValidTriangle() {
        // Классический треугольник 3-4-5
        double result = TriangleArea.byThreeSides(3, 4, 5);
        assertEquals(6.0, result, DELTA);
    }

    @Test
    void byThreeSides_shouldThrowException_whenTriangleInequalityViolated() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.byThreeSides(1, 2, 3));
    }

    @Test
    void byThreeSides_shouldThrowException_whenSideIsZero() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleArea.byThreeSides(3, 4, 0));
    }
}
