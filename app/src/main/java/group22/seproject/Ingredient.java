package group22.seproject;

import java.util.ArrayList;

public class Ingredient {
    private String name;
    private double calories;

    // ADDED THIS NEW ATTRIBUTE IN; SHOULD MAKE SEARCHBYINGREDIENT MORE EFFICIENT (NEED IT TOO AS PER DIAGRAM)
    private ArrayList<Recipe> associatedRecipes = new ArrayList<Recipe>();




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

    public ArrayList<Recipe> getRecipes() {
        return associatedRecipes;
    }
}
