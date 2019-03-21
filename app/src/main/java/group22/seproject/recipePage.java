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


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        ArrayList<Ingredient> ingred1 = new ArrayList<>();
        ingred1.add(new Ingredient("pasta",50));
        ingred1.add(new Ingredient("tomato", 20));
        ArrayList<String> instruc1 = new ArrayList<>();
        instruc1.add("boil the water");
        instruc1.add("add pasta");
        final Recipe recipe1 = new Recipe ("Beef stroganoff", ingred1, instruc1, 80, 60);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_front_page);
        txtname = (TextView) findViewById(R.id.rname);
        txtname.setText(recipe1.getName());


        txtduration = (TextView) findViewById(R.id.rduration);
        txtduration.setText("Duration: " + recipe1.getDuration());


        txtcalories = (TextView) findViewById(R.id.rcalories);
        txtcalories.setText("Total Calories: " + recipe1.getTotalcalories());


        ingred = (ListView) findViewById(R.id.listingredients);
        ArrayAdapter adapter = new ArrayAdapter(recipePage.this, android.R.layout.activity_list_item, recipe1.getIngredients());
        ingred.setAdapter(adapter);

        instruc = (ListView) findViewById(R.id.listinstructions);
        ArrayAdapter adapter1 = new ArrayAdapter(recipePage.this, android.R.layout.activity_list_item, recipe1.getInstructions());
        instruc.setAdapter(adapter1);


        stars = (RatingBar) findViewById(R.id.ratingBar);
        submitbutton = (Button) findViewById(R.id.submit_button);
        submitbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                recipe1.setTotalRating(stars.getRating());
                recipe1.setTotalVotes();

                Intent intent = new Intent(v.getContext(),WriteReview.class);
                startActivity(intent);


                Intent i = getIntent();
                String rev = i.getStringExtra("value");
                if (rev != null){
                    recipe1.setReviews(rev);
                }

            }
        });

        average  = (TextView) findViewById(R.id.avgRating);
        if (recipe1.getTotalVotes()==0) {
            average.setText("This recipe has no ratings");
        }

        else {
            average.setText("Average Rating: " + (recipe1.getTotalRating()/recipe1.getTotalVotes()));
        }

        showrev = (TextView) findViewById(R.id.showReviews);
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