package org.example.animals;

public class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public void addFood(int foodAmount) {
        this.foodAmount += foodAmount;
    }

    public boolean takeFood(int foodAmount) {
        if (foodAmount <= this.foodAmount) {
            this.foodAmount -= foodAmount;
            return true;
        }
        return false;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
