package group22.seproject;

import android.app.Activity;
import android.content.res.AssetManager;

import java.util.ArrayList;
import java.io.*;


public class RecipeBook extends Activity {

    private static RecipeBook instance = null;
    private ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    private ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
    private ArrayList<Recipe> pendingRecipes = new ArrayList<Recipe>();

    private RecipeBook() {

        // I/O METHOD
        File dir = new File("../../../../../sampledata/recipes"); // direcotry for all recipes
        File[] dirListing = dir.listFiles();
        if (dirListing != null) {
            for (File recipeFile : dirListing) {
                try {
                    FileInputStream fis = openFileInput(recipeFile.getName());
                    int charBit;
                    String temp = "";
                    int n = 0;
                    while ((charBit = fis.read()) != -1) {
                        temp = temp + Character.toString((char) charBit);
                    }
                    String[] firstSplit = temp.split("£");
                    while (n < firstSplit.length) {
                        firstSplit[n] = firstSplit[n].substring(0, firstSplit[n].length() - 1); //how recipes will look, reviews sep by another char
                        System.out.println(firstSplit[n]);
                        n++;
                    }
                } catch (FileNotFoundException f) {
                    System.out.println("File not found");
                } catch (IOException e) {
                    System.out.println("I/O Error occurred");
                }
            }
        }











        // CODE TO LOOK THROUGH ALL FILES IN DATABASE (FOLDER) AND EXTRACT ALL RECIPES/INGREDIENTS AND INIT OBJECTSt
        /*try {

            String recipeName = "";
            double recipeDuration = 0;
            double recipeCalories = 0;


            String line;
            int lineNumber;
            int blankline;


            FileInputStream fis;
            BufferedReader bufferedReader;


            AssetManager assetManager = getAssets(); String[] files = assetManager.list("");

            ArrayList<Ingredient> tempIngrHolder;
            ArrayList<String> instructions;


            // for every file in the recipes folder
            File dir = new File("../../../../../sampledata/recipes"); // direcotry for all recipes
            File[] dirListing = dir.listFiles();
            if (dirListing != null) {
                for (File recipeFile : dirListing) {

                    // runs through current file and extracts data --> becomes new Recipe/Ingredient objects & added to RecipeBook
                    line = null;
                    lineNumber = 1;
                    blankline = 0;

                    fis = new FileInputStream(recipeFile);
                    bufferedReader = new BufferedReader(fis);


                    tempIngrHolder = new ArrayList<Ingredient>(); // temporary holder that after going through file, is passed to Recipe constructor
                    instructions = new ArrayList<String>();

                    while ((line = bufferedReader.readLine()) != null) { // WILL THIS STOP AT LINE 4 WHEN THE LINE IS EMPTY??

                        if (lineNumber == 1) {
                            recipeName = line; // extract Recipe name
                            lineNumber += 1;
                        } else if (lineNumber == 2) {
                            recipeCalories = Double.parseDouble(line); // extract Recipe calories
                            lineNumber += 1;
                        } else if (lineNumber == 3) {
                            recipeDuration = Double.parseDouble(line); // extract Recipe duration
                            lineNumber += 1;

                        } else if (line.isEmpty()) {
                            blankline += 1;

                        } else {
                            if (blankline == 1) {
                                String[] ingredient = line.split(" ");               //should ingredients be of objects or strings?
                                Ingredient ing = new Ingredient(ingredient[0], Double.parseDouble(ingredient[1]));
                                tempIngrHolder.add(ing); //add Ingredient to temporary holder
                                this.ingredientList.add(ing);            //same change for Recipe class?

                            } else if (blankline == 2) {
                                String instruction = line;
                                instructions.add(instruction);
                            }
                        }
                    }
                    // TODO: ADD PART THAT WILL UPDATE ASSOCIATED RECIPES IN EACH INGREDIENT OBJECT

                    bufferedReader.close();
                    Recipe newRec = new Recipe(recipeName, tempIngrHolder, instructions, recipeCalories, recipeDuration);
                    this.recipeList.add(newRec);
                }

            } else {
                // HANDLE CASE WHERE IT IS NOT A DIRECTORY
            }
        } catch (IOException e) {
            System.out.println("ERROR");
        }*/
    }



    public ArrayList<Recipe> getPendingRecipes() {
        return pendingRecipes;
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

    public static void main (String[] args) {
        // TODO: GET THE RECIPEBOOK TO READ THE FILES...


    }


}