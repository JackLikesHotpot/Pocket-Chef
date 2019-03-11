package group22.seproject;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;

public abstract class User {

    private ArrayList<Recipe> savedRecipes = new ArrayList<Recipe>();
    private ArrayList<Reminder> reminders = new ArrayList<Reminder>();

    public ArrayList<Recipe> searchByName(String recipeName) {

        ArrayList<Recipe> returnedRecs = new ArrayList<Recipe>();
        ArrayList<Recipe> recipeList = RecipeBook.getInstance().getRecipes();

        for(int i = 0; i < recipeList.size(); i++) {
            if(recipeList.get(i).getName().equals(recipeName)) {
                returnedRecs.add(recipeList.get(i));
            }
        }
        return returnedRecs;
    }

    //TODO: UN-SAVE RECIPE METHOD?


    public void setReminder(Calendar startDate, Time time, Recipe recipe) {
        Reminder rem = new Reminder(startDate, time);
        return;
    }

    public void saveRecipe(Recipe recipe) {
        this.savedRecipes.add(recipe);
        return;
    }

    public ArrayList<Recipe> searchByIngredient(ArrayList<Ingredient> ingredients) {

        ArrayList<Recipe> returnedRecs = new ArrayList<Recipe>();
        ArrayList<Recipe> recipeList = RecipeBook.getInstance().getRecipes();

        //TODO: IMPLEMENT FOR LOOP TO FIND RECIPE THAT CONTAIN INGREDIENT
        return null; // for now
    }



    public void editReminder(Reminder reminder){
        // TODO: HOW TO IMPLEMENT THIS?
        return;
    }

    public void deleteReminder(Reminder reminder){
        reminder = null;
        return;
    }
}