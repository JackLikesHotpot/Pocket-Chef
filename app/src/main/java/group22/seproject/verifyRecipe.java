package group22.seproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class verifyRecipe extends AppCompatActivity {

    Recipe pendingRecipe;
    ArrayList<String> ingredientsString = new ArrayList<String>();
    ArrayList<String> caloriesString = new ArrayList<String>();

    TextView recipeNameTV;
    ListView ingreidentsLV;
    ListView caloriesLV;
    TextView descriptionTV;
    TextView durationTV;
    TextView totalCalsTV;
    Button acceptBtn;
    Button rejectBtn;
    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(verifyRecipe.this, android.R.layout.simple_list_item_1, ingredientsString);
    final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(verifyRecipe.this, android.R.layout.simple_list_item_1, caloriesString);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verify_recipe);

        // fetch and create new Recipe object from pending list based on the passed recipe name

        String recipeName = getIntent().getStringExtra("RecipeName");
        ArrayList<Recipe> pendingList = RecipeBook.getInstance().getPendingRecipes();
        for(int i = 0; i < pendingList.size(); i++) {
            if(pendingList.get(i).getName().equals(recipeName)) {
                pendingRecipe = pendingList.get(i);
            }
        }
        ////////////////////////////////////////
        ////////////////////////////////////////

        // initialise all components from the verify_recipe.xml file
        recipeNameTV = findViewById(R.id.recipeNameTV);
        recipeNameTV.setText(pendingRecipe.getName());


        ingreidentsLV = findViewById(R.id.ingredientsLV);
        ingreidentsLV.setAdapter(adapter);
        String currentIngName;
        for(int i = 0; i < pendingRecipe.getIngredients().size(); i++) {
            currentIngName = pendingRecipe.getIngredients().get(i).getName();
            ingredientsString.add(currentIngName);
        }

        caloriesLV = findViewById(R.id.caloriesLV);
        caloriesLV.setAdapter(adapter2);
        double currentIngCal;
        for(int i = 0; i < pendingRecipe.getIngredients().size(); i++) {
            currentIngCal = pendingRecipe.getIngredients().get(i).getCalories();
            caloriesString.add(Double.toString(currentIngCal));
        }


        descriptionTV = findViewById(R.id.descriptionTV);
        for(int i = 0; i < pendingRecipe.getInstructions().size(); i++) {
            descriptionTV.append(pendingRecipe.getInstructions().get(i));

        }

        durationTV = findViewById(R.id.durationTV);
        durationTV.setText(Double.toString(pendingRecipe.getDuration()));

        totalCalsTV = findViewById(R.id.totalCalsTV);
        totalCalsTV.setText(Double.toString(pendingRecipe.getTotalcalories()));


        acceptBtn = findViewById(R.id.acceptBtn);
        rejectBtn = findViewById(R.id.rejectBtn);
        ///////////////////////////////////////


        /// button handlers ///

        acceptBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO: CODE TO ACCEPT RECIPE AND SEND USER TO THAT RECIPE'S PAGE

            }


        });

        rejectBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO: CODE TO REJECT RECIPE AND MAKE USER EDIT THEIR RECIPE DETAILS

            }


        });




    }
}
