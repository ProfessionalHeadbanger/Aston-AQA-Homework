package org.example.animals;

public class Cat extends Animal {
    private static int catsCount = 0;
    private boolean satiety;

    public Cat(String name) {
        super(name, 200, 0);
        satiety = false;
        catsCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " пробежал " + maxRunDistance + " м и перехотел дальше бежать. Оставшиеся "
                    + (distance - maxRunDistance) + " м - ну может и пробежит когда-нибудь.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " плавать не пойдет, он же не умеет...");
    }

    public static int getCatsCount() {
        return catsCount;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }

    public void eatFromBowl(Bowl bowl, int foodAmount) {
        if (satiety) {
            System.out.println(name + " не стал есть, так как он уже сыт.");
            return;
        }

        if (bowl.takeFood(foodAmount)) {
            satiety = true;
            System.out.println(name + " покушал.");
        } else {
            System.out.println(name + " не смог покушать, еды не хватило.");
        }
    }
}
