package org.example;

import org.example.animals.Animal;
import org.example.animals.Bowl;
import org.example.animals.Cat;
import org.example.animals.Dog;
import org.example.calculator.Circle;
import org.example.calculator.GeometricFigure;
import org.example.calculator.Rectangle;
import org.example.calculator.Triangle;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    public static void task1() {
        Animal dog = new Dog("Бобик");
        Animal cat = new Cat("Мурзик");

        dog.run(100);
        dog.run(600);
        dog.swim(5);
        dog.swim(15);

        cat.run(100);
        cat.run(600);
        cat.swim(5);

        System.out.println(Animal.getAnimalsCount());
        System.out.println(Dog.getDogsCount());
        System.out.println(Cat.getCatsCount());

        System.out.println();

        Bowl bowl = new Bowl(50);
        bowl.addFood(50);
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Тапок");
        cats[1] = new Cat("Валенок");
        cats[2] = new Cat("Ботинок");
        cats[3] = new Cat("Степан");
        cats[4] = new Cat("Рыжик");
        Random random = new Random();
        for (Cat value : cats) {
            value.eatFromBowl(bowl, random.nextInt(20) + 10);
            System.out.println("В миске осталось " + bowl.getFoodAmount() + " еды.");
            if (value.isSatiety()) {
                System.out.println("Котик " + value.getName() + " сытый.");
            } else {
                System.out.println("Котик " + value.getName() + " голодный.");
            }
        }
    }

    public static void task2() {
        GeometricFigure circle = new Circle(5, "Красный", "Чёрный");
        GeometricFigure rectangle = new Rectangle(4, 6, "Синий", "Белый");
        GeometricFigure triangle = new Triangle(3, 4, 5, "Зелёный", "Жёлтый");

        circle.printInfo();
        System.out.println();
        rectangle.printInfo();
        System.out.println();
        triangle.printInfo();
        System.out.println();
    }
}
