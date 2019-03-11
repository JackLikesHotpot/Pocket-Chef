package group22.seproject;

import java.util.ArrayList;


public class RecipeBook {

    private static RecipeBook instance = null;
    private ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    private ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

    private RecipeBook() {
    }

    public static RecipeBook getInstance() {
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