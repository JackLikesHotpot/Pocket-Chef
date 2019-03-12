package group22.seproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class readCreateRecipe {

    private String recipeName = "";
    private double recipeDuration = 0;
    private double recipeCalories = 0;
    private ArrayList<String> ingredients = new ArrayList<String>();
    private ArrayList<String> instructions = new ArrayList<String>();

    public void main(String[] args) {
        String filename = "./app/sampledata/pizza.txt/";

        String line = null;
        int lineNumber = 1;
        int blankline = 0;

        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {

                if (lineNumber == 1) {
                    this.recipeName = line;
                    lineNumber += 1;
                } else if (lineNumber == 2) {
                    this.recipeCalories = Double.parseDouble(line);
                    lineNumber += 1;
                } else if (lineNumber == 3) {
                    this.recipeDuration = Double.parseDouble(line);
                    lineNumber += 1;

                } else if (line.isEmpty()){
                    blankline += 1;

                } else {
                    if (blankline == 1){
                        String ingredient = line;               //should ingredients be of objects or strings?
                        ingredients.add(ingredient);            //same change for Recipe class?
                    }
                    else if (blankline == 2){
                        String instruction = line;
                        instructions.add(instruction);
                    }
                }
            }
            //Recipe newR = new Recipe(this.recipeName, this.recipeCalories, this.recipeDuration, this.ingredients, this.instructions);

            bufferedReader.close();
        }

        catch(FileNotFoundException ex) {
            System.out.print("file not found");
        }

        catch (IOException ex) {
            System.out.println("IO error");
        }
    }
}
