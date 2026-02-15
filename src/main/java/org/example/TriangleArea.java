package org.example;

public class TriangleArea {
    public static double byBaseAndHeight(double base, double height) {
        validatePositive(base, height);
        return 0.5 * base * height;
    }

    public static double byTwoSidesAndAngle(double a, double b, double angleDegrees) {
        validatePositive(a, b);
        validateAngle(angleDegrees);

        double angleRadians = Math.toRadians(angleDegrees);
        return 0.5 * a * b * Math.sin(angleRadians);
    }

    public static double byThreeSides(double a, double b, double c) {
        validatePositive(a, b, c);
        validateTriangleInequality(a, b, c);

        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    private static void validatePositive(double... values) {
        for (double value : values) {
            if (value <= 0) {
                throw new IllegalArgumentException("All values must be positive");
            }
        }
    }

    private static void validateAngle(double angleDegrees) {
        if (angleDegrees <= 0 || angleDegrees >= 180) {
            throw new IllegalArgumentException("Angle must be between 0 and 180 degrees");
        }
    }

    private static void validateTriangleInequality(double a, double b, double c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Triangle inequality violated");
        }
    }
}
