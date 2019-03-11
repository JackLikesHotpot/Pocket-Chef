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

        ArrayList<Recipe> returnedRecs = new ArrayList<Recipe>(); // RECS TO BE RETURNED
        ArrayList<Ingredient> recipeBookIngreds = RecipeBook.getInstance().getIngredients(); // TEMP RECIPEBOOK INGREDIENTS LIST VARIABLE

        // 1. LOOPS THROUGH ALL INGREDIENTS IN PASSED ARGUMENT
        // 2. AT EACH LOOP, FURTHER LOOPS THROUGH ALL INGREDIENTS IN RECIPEBOOK INGREDIENTS ARRAY
        // 3. CHECKS IF CURRENT ARGUMENT INGREDIENT MATCHES CURRENT RECIPEBOOK INGREDIENT BY NAME
        // 4. IF SO, ADDS ALL ASSOCIATED RECIPES TO ARRAY TO BE RETURNED, THEN BREAKS

        for(int i = 0; i < ingredients.size(); i++) {
            for(int j = 0; j < recipeBookIngreds.size(); j++) {
                if(ingredients.get(i).getName().equals(recipeBookIngreds.get(j).getName())) {
                    returnedRecs.addAll(recipeBookIngreds.get(j).getRecipes()); // MAY RETURN DUPLICATES FOR EACH i LOOP
                    break;
                }
            }
        }
        return returnedRecs;
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