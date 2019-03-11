package group22.seproject;

public class Ingredient {
    private String name;
    private double calories;

    Ingredient(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }

    public double getCalories() {
        return this.calories;
    }

    public String getName() {
        return this.name;
    }
}
