package group22.seproject;

import java.util.ArrayList;
import java.io.*;


public class RecipeBook {

    private static RecipeBook instance = null;
    private ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    private ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

    private RecipeBook() throws IOException {

        // CODE TO LOOK THROUGH ALL FILES IN DATABASE (FOLDER) AND EXTRACT ALL RECIPES/INGREDIENTS AND INIT OBJECTSt

        BufferedReader inputStream;
        String recipeName = "";
        double recipeDuration = 0;
        double recipeCalories = 0;
        ArrayList<String> ingredients = new ArrayList<String>();
        ArrayList<String> instructions = new ArrayList<String>();

        File dir = new File("../../../../../sampledata/recipes"); // direcotry for all recipes
        File[] dirListing = dir.listFiles();
        if(dirListing != null) {
            for(File recipeFile : dirListing) {

                // COLLECT EACH FILE DATA, CREATE NEW OBJECTS, ADD TO RECIPEBOOK, ETC
                inputStream = new BufferedReader(new FileReader(recipeFile)); // inputStream for current Recipe file
                recipeName = inputStream.readLine();
                recipeDuration = Double.parseDouble(inputStream.readLine());
                recipeCalories = Double.parseDouble(inputStream.readLine());






                inputStream.close();

            }
        }

        else {
            // HANDLE CASE WHERE IT IS NOT A DIRECTORY
        }
    }

    public static RecipeBook getInstance() throws IOException {
        if (instance == null) {
            instance = new RecipeBook();
        }
        return instance;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipeList;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredientList;
    }


    public boolean addRecipeEntry(Recipe recipe) {
        this.recipeList.add(recipe);
        return true;
    }

    public boolean addIngredientEntry(Ingredient ingredient) {
        this.ingredientList.add(ingredient);
        return true;
    }

    public boolean removeRecipeEntry(Recipe recipe) {
        Recipe recipe_i = null;
        for (int i = 0; i < recipeList.size(); i++) {
            recipe_i = recipeList.get(i);
            if (recipe_i.getName().equals(recipe.getName())) {
                recipeList.remove(recipe_i);
                return true;
            }
        }
        return false;
    }

    public boolean removeIngredientEntry(Ingredient ingredient) {
        Ingredient ingredient_i = null;
        for (int i = 0; i < ingredientList.size(); i++) {
            ingredient_i = ingredientList.get(i);
            if (ingredient_i.getName().equals(ingredient.getName())) {
                recipeList.remove(ingredient_i);
                return true;
            }
        }
        return false;
    }
}