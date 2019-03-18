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

import java.util.ArrayList;

public class AddRecipe extends AppCompatActivity {
    String recipeName;
    String ingredientName;
    ArrayList<String> description = new ArrayList<String>();
    //TODO: INCLUDE CALORIES AND DURATION PARAMETERS TO ADD TO RECIPE OBJECT

    EditText recipeNameET;
    EditText descriptionET;
    TextView ingredientNameTV;

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
        ingredientNameTV = findViewById(R.id.ingredientNameTV);
        ingredientListLV = findViewById(R.id.ingredientListLV);
        addIngredientBTN = findViewById(R.id.addIngredientBTN);
        addRecipeBTN = findViewById(R.id.addRecipeBTN);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        ingredientListLV.setAdapter(adapter);







        addIngredientBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ingredientName = ingredientNameTV.toString();
                items.add(ingredientName);
                Ingredient ingredient = new Ingredient(ingredientName, 6); // example calorie
                ingredients.add(ingredient);
                adapter.notifyDataSetChanged();

            }
        });

        addRecipeBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                recipeName = recipeNameET.getText().toString();
                description.add(descriptionET.getText().toString());
                Recipe recipe = new Recipe(recipeName, ingredients, description, 5, 5 ); // example toalCal and duration
                RecipeBook.getInstance().addRecipeEntry(recipe);
                //TODO: add Recipe to User
            }
        });


    }

}
