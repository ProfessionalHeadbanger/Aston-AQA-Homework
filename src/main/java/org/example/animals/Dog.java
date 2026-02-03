package org.example.animals;

public class Dog extends Animal {
    private static int dogsCount = 0;

    public Dog(String name) {
        super(name, 500, 10);
        dogsCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " пробежал " + maxRunDistance + " м и устал. Оставшиеся "
                    + (distance - maxRunDistance) + " м - как нибудь в другой раз.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= maxSwimDistance) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " проплыл " + maxSwimDistance + " м и устал. Осталось "
                    + (distance - maxSwimDistance) + " м. Будем надеться, что он не утонет.");
        }
    }

    public static int getDogsCount() {
        return dogsCount;
    }
}
