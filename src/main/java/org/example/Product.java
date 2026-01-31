package org.example;

import java.time.LocalDate;

public class Product {
    private String name;
    private LocalDate date;
    private String manufacturer;
    private String country;
    private double price;
    private boolean reservationState;

    public Product(String name, LocalDate date, String manufacturer, String country,
                   double price, boolean reservationState) {
        this.name = name;
        this.date = date;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.reservationState = reservationState;
    }

    public void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + date);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: " + price);
        System.out.println("Состояние бронирования: " +
                (reservationState ? "Забронирован" : "Свободен"));
    }
}
