package group22.seproject;

import java.util.ArrayList;
import java.io.*;


public class RecipeBook {

    private static RecipeBook instance = null;
    private ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    private ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

    private RecipeBook() {

        // CODE TO LOOK THROUGH ALL FILES IN DATABASE (FOLDER) AND EXTRACT ALL RECIPES/INGREDIENTS AND INIT OBJECTSt
        try {

            String recipeName = "";
            double recipeDuration = 0;
            double recipeCalories = 0;
            ArrayList<String> ingredients = new ArrayList<String>();
            ArrayList<String> instructions = new ArrayList<String>();

            String line;
            int lineNumber;
            int blankline;
            FileReader fileReader;
            BufferedReader bufferedReader;


            // for every file in the recipes folder
            File dir = new File("../../../../../sampledata/recipes"); // direcotry for all recipes
            File[] dirListing = dir.listFiles();
            if (dirListing != null) {
                for (File recipeFile : dirListing) {

                    // runs through current file and extracts data --> becomes new Recipe/Ingredient objects & added to RecipeBook
                    line = null;
                    lineNumber = 1;
                    blankline = 0;

                    fileReader = new FileReader(recipeFile);
                    bufferedReader = new BufferedReader(fileReader);

                    while ((line = bufferedReader.readLine()) != null) { // WILL THIS STOP AT LINE 4 WHEN THE LINE IS EMPTY??

                        if (lineNumber == 1) {
                            recipeName = line;
                            lineNumber += 1;
                        } else if (lineNumber == 2) {
                            recipeCalories = Double.parseDouble(line);
                            lineNumber += 1;
                        } else if (lineNumber == 3) {
                            recipeDuration = Double.parseDouble(line);
                            lineNumber += 1;

                        } else if (line.isEmpty()) {
                            blankline += 1;

                        } else {
                            if (blankline == 1) {
                                String ingredient = line;               //should ingredients be of objects or strings?
                                ingredients.add(ingredient);            //same change for Recipe class?
                            } else if (blankline == 2) {
                                String instruction = line;
                                instructions.add(instruction);
                            }
                        }
                    }

                    Recipe newR = new Recipe(recipeName, recipeCalories, recipeDuration, ingredients, instructions);
                    this.recipeList.add(newR);

                    bufferedReader.close();
                }

























                    /*inputStream = new BufferedReader(new FileReader(recipeFile)); // inputStream for current Recipe file
                    recipeName = inputStream.readLine();
                    recipeDuration = Double.parseDouble(inputStream.readLine());
                    recipeCalories = Double.parseDouble(inputStream.readLine());
                    inputStream.readLine();

                    // LOOP FOR STORING INGREDIENTS IN ARRAY

                    while(inputStream.readLine() != null) {
                        ingredients.add(inputStream.readLine());
                    }


                    inputStream.close();*/


            } else {
                // HANDLE CASE WHERE IT IS NOT A DIRECTORY
            }
        }
        catch(IOException e) {

        }
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