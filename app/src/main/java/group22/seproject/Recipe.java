package group22.seproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Recipe {

    private ArrayList<String> instructions = new ArrayList<String>();
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private double totalcalories;
    private double duration;
    private String name;

    private double averageRating;
    private int totalVotes;
    private double totalRating;

    public Recipe(String recipeName, ArrayList<Ingredient> ingreds, ArrayList<String> instructs, double totalcalories, double duration) {

        this.name = recipeName;
        this.instructions = instructs;
        this.ingredients = ingreds;
        this.totalcalories = totalcalories;
        this.duration = duration;
        this.averageRating = 0;
        this.totalVotes = 0;
        this.totalRating = 0;
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public double getTotalcalories() {
        return totalcalories;
    }

    public double getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int rating) {
        averageRating = totalRating / totalVotes;
    }

    public double getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(int rating) {
        totalRating += rating;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes() {
        totalVotes += 1;
    }
}
