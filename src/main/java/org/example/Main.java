package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Product[] products = new Product[5];

        products[0] = new Product("Машинка для намотки струн гитары",
                LocalDate.of(2025, 12, 12),
                "Alice",
                "China",
                195,
                false);
        products[1] = new Product("Медиатор Dunlop 471RMT Mick Thomson Custom Jazz III",
                LocalDate.of(2024, 6, 23),
                "Dunlop",
                "USA",
                373,
                true);
        products[2] = new Product("Комплект для ухода за гитарой и струнными инструментами",
                LocalDate.of(2025, 1, 2),
                "OVTSound",
                "Russia",
                195,
                true);
        products[3] = new Product("Медиатор Alice AP-JM3",
                LocalDate.of(2023, 11, 17),
                "Alice",
                "China",
                223,
                false);
        products[4] = new Product("PETG CF (Carbon Fiber) пластик KINGROON",
                LocalDate.of(2026, 1, 30),
                "KINGROON",
                "China",
                1887,
                false);

        for (Product product : products) {
            product.printInfo();
            System.out.println();
        }

        Park park = new Park("Moonapark");
        Park.Ride[] rides = new Park.Ride[3];
        rides[0] = park.new Ride("Карусель-карусель",
                LocalTime.of(9, 0, 0),
                LocalTime.of(21, 0, 0),
                100);
        rides[1] = park.new Ride(
                "Колесо обозрения",
                LocalTime.of(10, 0),
                LocalTime.of(22, 0),
                300
        );
        rides[2] = park.new Ride(
                "Американские горки",
                LocalTime.of(12, 0),
                LocalTime.of(20, 0),
                500
        );

        park.printInfo();
        for (Park.Ride ride : rides) {
            ride.printInfo();
        }
    }
}
