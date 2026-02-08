package org.example;

import org.example.phonebook.Phonebook;
import org.example.student.Student;
import org.example.student.StudentUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        task1();
        System.out.println();
        task2();
    }

    public static void task1() {
        Set<Student> students = new HashSet<>();

        students.add(new Student(
                "Иван",
                "ИТ-21",
                1,
                Arrays.asList(4, 5, 3)
        ));

        students.add(new Student(
                "Мария",
                "ИТ-21",
                1,
                Arrays.asList(2, 2, 3)
        ));

        students.add(new Student(
                "Алексей",
                "ИТ-22",
                2,
                Arrays.asList(5, 4, 5)
        ));

        StudentUtils.removeBadStudents(students);

        StudentUtils.promoteStudents(students);

        System.out.println("Студенты 2 курса:");
        StudentUtils.printStudents(students, 2);
    }

    public static void task2() {
        Phonebook phoneBook = new Phonebook();

        phoneBook.add("Иванов", "123-45-67");
        phoneBook.add("Иванов", "987-65-43");
        phoneBook.add("Петров", "555-55-55");

        System.out.println("Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Петров: " + phoneBook.get("Петров"));
        System.out.println("Сидоров: " + phoneBook.get("Сидоров"));
    }
}
