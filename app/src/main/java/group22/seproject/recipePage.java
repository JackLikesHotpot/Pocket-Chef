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
    TextView showrev;


    Recipe recipe;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_front_page);

        ingred = (ListView) findViewById(R.id.listingredients);
        ArrayList<Ingredient> ingred1 = new ArrayList<>();
        ingred1.add(new Ingredient("pasta",50));
        ingred1.add(new Ingredient("tomato", 20));
        ArrayList<String> instruc1 = new ArrayList<>();
        instruc1.add("boil the water");
        instruc1.add("add pasta");
        final Recipe recipe = new Recipe ("Beef stroganoff", ingred1, instruc1, 80, 60);


        //////////////////////// Recipe Fetch ////////////////////////
     /*   ArrayList<Recipe> approvedRecs = RecipeBook.getInstance().getRecipes();
        String recipeName = getIntent().getStringExtra("recipeName"); // get Recipe Name from Intent

        for(int i = 0; i < approvedRecs.size(); i++) { // fetch the Recipe from the RecipeBook
            if(approvedRecs.get(i).getName().equals(recipeName)) {
                recipe = approvedRecs.get(i);
            }
        }
        //////////////////////////////////////////////////////////////
    */

        txtname = (TextView) findViewById(R.id.rname);
        txtname.setText(recipe.getName());


        txtduration = (TextView) findViewById(R.id.rduration);
        String durText = "Duration: " + Double.toString(recipe.getDuration());
        txtduration.setText(durText);


        ArrayAdapter adapter3 = new ArrayAdapter(recipePage.this, android.R.layout.simple_list_item_1, recipe.getIngredients());
        ingred.setAdapter(adapter3);

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
        ArrayAdapter adapter = new ArrayAdapter(recipePage.this, android.R.layout.simple_list_item_1, ingredientsString);
        ingred.setAdapter(adapter);



        /////////////////////////////////////////////////////////////////////////////////////







        instruc = (ListView) findViewById(R.id.listinstructions);
        ArrayAdapter adapter1 = new ArrayAdapter(recipePage.this, android.R.layout.simple_list_item_1, recipe.getInstructions());
        instruc.setAdapter(adapter1);


        stars = (RatingBar) findViewById(R.id.ratingBar);
        submitbutton = (Button) findViewById(R.id.submit_button);
        submitbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                recipe.setTotalRating((double)stars.getRating());
                recipe.setTotalVotes();

                Intent intent = new Intent(v.getContext(),WriteReview.class);
                startActivity(intent);


                Intent i = getIntent();
                String rev = i.getStringExtra("value");

                    recipe.setReviews(rev);


            }
        });

        average  = (TextView) findViewById(R.id.avgRating);
        if (recipe.getTotalVotes()==0) {
            average.setText("This recipe has no ratings");
        }

        else {
            average.setText("Average Rating: " + (recipe.getTotalRating()/recipe.getTotalVotes()));

        }

        showrev = (TextView) findViewById(R.id.showReviews);
        if (recipe.getReviews().isEmpty()) {
        }
        else {
            showrev.setText(recipe.getReviews().get(0));
        }
    }



    /*

    public void openDialog(){

        DialogClass popup = new DialogClass();
        popup.show(getSupportFragmentManager(), "dialog");

    }

    @Override
    public void applyTexts(String reviews) {
        recipe1.setReviews(reviews);
        ArrayAdapter adapter2 = new ArrayAdapter(recipePage.this, android.R.layout.activity_list_item, getReviews());
        instruc.setAdapter(adapter2);
    }
    */

}