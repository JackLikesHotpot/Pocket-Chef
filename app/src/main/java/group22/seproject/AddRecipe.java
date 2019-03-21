package group22.seproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddRecipe extends Activity {
    String recipeName;
    String ingredientName;
    String calorieValue;
    double duration;
    double totalCalories = 0;

    ArrayList<String> description = new ArrayList<String>();
    ArrayList<Review> reviews = new ArrayList<Review>();

    EditText recipeNameET;
    EditText descriptionET;
    EditText ingredientNameET;
    EditText ingredientCaloriesET;
    EditText recipeDurationET;

    ListView ingredientListLV;
    ArrayList<String> items = new ArrayList<String>();
    ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    ArrayAdapter<String> adapter;

    ListView ingredientCaloriesLV;
    ArrayList<String> calorieItems = new ArrayList<String>();
    ArrayAdapter<String> adapter2;



    Button addIngredientBTN;
    Button addRecipeBTN;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addrecipe);

        recipeNameET = findViewById(R.id.recipeNameET);
        descriptionET = findViewById(R.id.descriptionET);
        ingredientNameET = findViewById(R.id.ingredientNameET);
        ingredientCaloriesET = findViewById(R.id.ingredientCaloriesET);
        addIngredientBTN = findViewById(R.id.addIngredientBTN);
        recipeDurationET = findViewById(R.id.recipeDurationET);

        ingredientListLV = findViewById(R.id.ingredientListLV);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        ingredientListLV.setAdapter(adapter);

        ingredientCaloriesLV = findViewById(R.id.ingredientCaloriesLV);
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, calorieItems);
        ingredientCaloriesLV.setAdapter(adapter2);

        addRecipeBTN = findViewById(R.id.addRecipeBTN);
        addIngredientBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(ingredientNameET.length() == 0 || ingredientCaloriesET.length() == 0) {
                    Toast warning = Toast.makeText(AddRecipe.this, "Ingredient Name and Calories fields must both be filled", Toast.LENGTH_SHORT);
                    warning.show();
                }

                else {
                    ingredientName = ingredientNameET.getText().toString();
                    items.add(ingredientName);

                    calorieValue = ingredientCaloriesET.getText().toString();
                    calorieItems.add(calorieValue);

                    Ingredient ingredient = new Ingredient(ingredientName, Double.parseDouble(calorieValue)); // example calorie
                    ingredients.add(ingredient);
                    totalCalories += Double.parseDouble(calorieValue);

                    adapter.notifyDataSetChanged();
                    adapter2.notifyDataSetChanged();
                    ingredientNameET.setText("");
                    ingredientCaloriesET.setText("");
                }

            }
        });

        addRecipeBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if ((recipeNameET.length() == 0 || adapter.getCount() == 0) || (descriptionET.length() == 0 || recipeDurationET.length() == 0)) {
                    Toast toast = Toast.makeText(AddRecipe.this, "Fields cannot be empty!", Toast.LENGTH_SHORT);
                    toast.show();
                }

                else {

                    recipeName = recipeNameET.getText().toString();
                    duration = Double.parseDouble(recipeDurationET.getText().toString());
                    description.add(descriptionET.getText().toString());

                    Recipe recipe = new Recipe(recipeName, ingredients, description, totalCalories, duration);
                    RecipeBook.getInstance().getPendingRecipes().add(recipe);

                    Toast toast = Toast.makeText(AddRecipe.this, "Recipe uploaded successfully. Awaiting verification.", Toast.LENGTH_SHORT);
                    toast.show();
                   /* try {
                        Thread.sleep(500);
                    }
                    catch(InterruptedException e) {} */

                    Intent login = new Intent(AddRecipe.this, LoginRegister.class);
                    startActivity(login);

                    //RecipeBook.getInstance().addRecipeEntry(recipe);


                        //TODO: add Recipe to User
                }
            }
        });


    }

}
