package org.example.calculator;

public interface GeometricFigure {
    default double calculatePerimeter() {
        return 0.0;
    }

    default double calculateArea() {
        return 0.0;
    }

    default void printInfo() {
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }

    String getFillColor();
    String getBorderColor();
}
