package org.example.animals;

public abstract class Animal {
    protected String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;

    protected static int animalsCount = 0;

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        animalsCount++;
    }

    public static int getAnimalsCount() {
        return animalsCount;
    }

    abstract public void run(int distance);
    abstract public void swim(int distance);
}
