package org.example;

import java.time.LocalTime;

public class Park {
    private String name;

    public Park(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println("Добро пожаловать в парк \"" + name + "\"");
    }

    public class Ride {
        private String rideName;
        private LocalTime openTime;
        private LocalTime closeTime;
        private double price;

        public Ride(String rideName, LocalTime openTime, LocalTime closeTime, double price) {
            this.rideName = rideName;
            this.openTime = openTime;
            this.closeTime = closeTime;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + rideName);
            System.out.println("Время работы: " + openTime + " - " + closeTime);
            System.out.println("Стоимость: " + price);
        }
    }
}
