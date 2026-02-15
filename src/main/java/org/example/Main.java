package org.example;

import java.util.Scanner;

public class Main {
    public static void triangleAreaMenu(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("Выберите способ: ");
            System.out.println("1. Через основание и высоту");
            System.out.println("2. Через две стороны и угол между ними");
            System.out.println("3. Через три стороны");
            System.out.println("0. Назад");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введите основание: ");
                    double base = scanner.nextDouble();
                    System.out.print("Введите высоту: ");
                    double height = scanner.nextDouble();
                    System.out.println("Площадь равна " +
                            TriangleArea.byBaseAndHeight(base, height));
                    break;

                case 2:
                    System.out.print("Введите первую сторону: ");
                    double s1 = scanner.nextDouble();
                    System.out.print("Введите вторую сторону: ");
                    double s2 = scanner.nextDouble();
                    System.out.print("Введите угол между сторонами в градусах: ");
                    double angle = scanner.nextDouble();
                    System.out.println("Площадь равна " +
                            TriangleArea.byTwoSidesAndAngle(s1, s2, angle));
                    break;

                case 3:
                    System.out.print("Введите первую сторону: ");
                    double t1 = scanner.nextDouble();
                    System.out.print("Введите вторую сторону: ");
                    double t2 = scanner.nextDouble();
                    System.out.print("Введите третью сторону: ");
                    double t3 = scanner.nextDouble();
                    System.out.println("Площадь равна " +
                            TriangleArea.byThreeSides(t1, t2, t3));
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Неправильный ввод");
            }
        }
    }

    public static void calculatorMenu(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.print("Введите первое число: ");
            int a = scanner.nextInt();
            System.out.print("Введите второе число: ");
            int b = scanner.nextInt();

            System.out.println("Выберите операцию: ");
            System.out.println("1. Сложение");
            System.out.println("2. Вычитание");
            System.out.println("3. Умножение");
            System.out.println("4. Деление");
            System.out.println("0. Назад");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(a + " + " + b + " = " + Calculator.add(a, b));
                    break;
                case 2:
                    System.out.println(a + " - " + b + " = " + Calculator.subtract(a, b));
                    break;
                case 3:
                    System.out.println(a + " * " + b + " = " + Calculator.multiply(a, b));
                    break;
                case 4:
                    System.out.println(a + " / " + b + " = " + Calculator.divide(a, b));
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неправильный ввод");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Выберите действие: ");
            System.out.println("1. Вычислить факториал числа");
            System.out.println("2. Найти площадь треугольника");
            System.out.println("3. Выполнить арифметические действие с двумя числами");
            System.out.println("4. Сравнить два числа");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Введите число: ");
                        int number = scanner.nextInt();
                        int result = Factorial.calculate(number);
                        System.out.println(number + "! = " + result);
                        break;
                    case 2:
                        triangleAreaMenu(scanner);
                        break;
                    case 3:
                        calculatorMenu(scanner);
                        break;
                    case 4:
                        System.out.print("Введите первое число: ");
                        int a = scanner.nextInt();
                        System.out.print("Введите второе число: ");
                        int b = scanner.nextInt();

                        switch (Comparator.compare(a, b)) {
                            case 1:
                                System.out.println(a + " > " + b);
                                break;
                            case -1:
                                System.out.println(a + " < " + b);
                                break;
                            case 0:
                                System.out.println(a + " = " + b);
                                break;
                        }
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Неправильный ввод");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }

        scanner.close();
    }
}
