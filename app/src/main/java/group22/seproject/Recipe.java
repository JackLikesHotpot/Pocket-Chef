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
    private ArrayList<String> instruct = new ArrayList<String>();   //TEST VARIABLES
    private ArrayList<Ingredient> ingreTest = new ArrayList<Ingredient>();

    public Recipe(String recipeName, double totalcalories, double duration) throws Exception {

        name = recipeName;
        this.instructions = instruct;
        this.ingredients = ingreTest;
        this.totalcalories = totalcalories;
        this.duration = duration;
        averageRating = 0;
        totalVotes = 0;
        totalRating = 0;
    }

    public static void main(String[] args) throws Exception {       //can be moved later. generates recipe.
        //Recipe recipe = new Recipe();

    }

    public ArrayList<String> getInstructions() {
        return instructions;
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
