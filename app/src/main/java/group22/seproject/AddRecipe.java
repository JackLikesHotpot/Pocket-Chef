package group22.seproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddRecipe extends AppCompatActivity {
    String recipeName;
    String ingredientName;
    ArrayList<String> description = new ArrayList<String>();
    ArrayList<Review> reviews = new ArrayList<Review>();
    //TODO: INCLUDE CALORIES AND DURATION PARAMETERS TO ADD TO RECIPE OBJECT

    EditText recipeNameET;
    EditText descriptionET;
    EditText ingredientNameET;

    ListView ingredientListLV;
    ArrayList<String> items = new ArrayList<String>();
    ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    ArrayAdapter<String> adapter;

    Button addIngredientBTN;
    Button addRecipeBTN;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addrecipe);

        recipeNameET = findViewById(R.id.recipeNameET);
        descriptionET = findViewById(R.id.descriptionET);
        ingredientNameET = findViewById(R.id.ingredientNameET);
        ingredientListLV = findViewById(R.id.ingredientListLV);
        addIngredientBTN = findViewById(R.id.addIngredientBTN);
        addRecipeBTN = findViewById(R.id.addRecipeBTN);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        ingredientListLV.setAdapter(adapter);







        addIngredientBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ingredientName = ingredientNameET.getText().toString();
                items.add(ingredientName);
                Ingredient ingredient = new Ingredient(ingredientName, 6); // example calorie
                ingredients.add(ingredient);
                adapter.notifyDataSetChanged();
                ingredientNameET.setText("");

            }
        });

        addRecipeBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if ((recipeName.isEmpty() || items.isEmpty()) || description.isEmpty()) {
                    Toast toast = Toast.makeText(AddRecipe.this, "Fields cannot be empty!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {

                    recipeName = recipeNameET.getText().toString();
                    description.add(descriptionET.getText().toString());
                    Recipe recipe = new Recipe(recipeName, ingredients, description, 5, 5); // example toalCal and duration

                    // TODO: ADMIN MUST VERIFY THE RECIPE BEFORE IT CAN BE CREATED
                    if(admin.approveRecipe(recipe)) {
                        registeredUser.addRecipe();
                        RecipeBook.getInstance().addRecipeEntry(recipe);
                        Toast toast = Toast.makeText(AddRecipe.this, "Recipe uploaded successfully.", Toast.LENGTH_SHORT);
                        toast.show();
                        Intent goBack = new Intent(AddRecipe.this, SearchActivity.class);
                        startActivity(goBack);
                        //TODO: add Recipe to User
                    }
                    else {
                        //NOTIFY THAT RECIPE WAS REJECTED
                    }



                }
            }
        });


    }

}
