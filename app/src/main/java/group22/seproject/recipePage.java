package group22.seproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;


public class recipePage extends Activity  {

    TextView txtname;
    TextView txtduration;
    TextView txtcalories;
    ListView ingred;
    ListView instruc;
    RatingBar stars;
    Button submitbutton;
    TextView average;
    ListView showrev;


    Recipe recipe;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_front_page);
        //listenerForRating();

        ArrayList<Recipe> approvedRecs = RecipeBook.getInstance().getRecipes();
            String recipeName = getIntent().getStringExtra("recipeName"); // get Recipe Name from Intent

            for (int i = 0; i < approvedRecs.size(); i++) { // fetch the Recipe from the RecipeBook
                if (approvedRecs.get(i).getName().equals(recipeName)) {
                    recipe = approvedRecs.get(i);
                }
            }



        txtname = (TextView) findViewById(R.id.rname);
        txtname.setText(recipe.getName());


        txtduration = (TextView) findViewById(R.id.rduration);
        String durText = "Duration: " + Double.toString(recipe.getDuration());
        txtduration.setText(durText);


        txtcalories = (TextView) findViewById(R.id.rcalories);
        String calText = "Total Calories: " + Double.toString(recipe.getTotalcalories());
        txtcalories.setText(calText);


        //////////////////////// Display Ingedients in String format ////////////////////////

        ArrayList<String> ingredientsString = new ArrayList<String>();
        String ingredName;
        String ingredCal;
        Ingredient currentIng;
        for(int j = 0; j < recipe.getIngredients().size(); j++) {
            currentIng = recipe.getIngredients().get(j);
            ingredName = currentIng.getName();
            ingredCal = Double.toString(currentIng.getCalories());
            ingredientsString.add(ingredName + ", " + ingredCal);
        }


        ingred = (ListView) findViewById(R.id.listingredients);
        ArrayAdapter adapter2 = new ArrayAdapter(recipePage.this, android.R.layout.simple_list_item_1, ingredientsString);
        ingred.setAdapter(adapter2);


        /////////////////////////////////////////////////////////////////////////////////////


        instruc = (ListView) findViewById(R.id.listinstructions);
        ArrayAdapter adapter1 = new ArrayAdapter(recipePage.this, android.R.layout.simple_list_item_1, recipe.getInstructions());
        instruc.setAdapter(adapter1);


        stars = (RatingBar) findViewById(R.id.ratingBar);

        submitbutton = (Button) findViewById(R.id.submit_button);
        submitbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                double aux = stars.getNumStars();
                recipe.setTotalRating(aux);
                recipe.setTotalVotes();

                Intent intent = new Intent(recipePage.this, WriteReview.class);
                startActivityForResult(intent, 1);

            }
        });

        average  = (TextView) findViewById(R.id.avgRating);
        if (recipe.getTotalVotes()==0) {
            average.setText("This recipe has no ratings");
        }
        else {
            average.setText("Average Rating: " + (recipe.getTotalRating()/recipe.getTotalVotes()));

        }

        showrev = (ListView) findViewById(R.id.rewi);
        ArrayAdapter adapter4 = new ArrayAdapter(recipePage.this, android.R.layout.simple_list_item_1, recipe.getReviews());
        showrev.setAdapter(adapter4);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String res = data.getStringExtra("result");
                recipe.setReviews(res);
            }
        }
    }


}