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

public class recipePage extends Activity  implements DialogClass.DialogClassListener {

    TextView txtname;
    TextView txtduration;
    TextView txtcalories;
    ListView ingred;
    ListView instruc;
    RatingBar stars;
    Button submitbutton;
    TextView average;
    TextView showrev;


    String recipename;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Recipe recipe1 = new Recipe ("pasta")
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_front_page);
        txtname = (TextView) findViewById(R.id.rname);
        txtname.setText(Recipe.getName());


        txtduration = (TextView) findViewById(R.id.rduration);
        txtduration.setText("Duration: " + getDuration());


        txtcalories = (TextView) findViewById(R.id.rcalories);
        txtcalories.setText("Total Calories: " + getTotalcalories());


        ingred = (ListView) findViewById(R.id.listingredients);
        ArrayAdapter adapter = new ArrayAdapter(recipePage.this, android.R.layout.activity_list_item, getIngredients());
        ingred.setAdapter(adapter);

        instruc = (ListView) findViewById(R.id.listinstructions);
        ArrayAdapter adapter1 = new ArrayAdapter(recipePage.this, android.R.layout.activity_list_item, getInstructions());
        instruc.setAdapter(adapter1);


        stars = (RatingBar) findViewById(R.id.ratingBar);
        submitbutton = (Button) findViewById(R.id.submit_button);
        submitbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                setTotalRating(stars.getRating());
                setTotalVotes();

                openDialog();
            }
        });

        average  = (TextView) findViewById(R.id.avgRating);
        if (getTotalVotes()==0) {
            average.setText("This recipe has no ratings");
        }

        else {
            average.setText("Average Rating: " + (getTotalRating()/getTotalVotes()));
        }

        showrev = (TextView) findViewById(R.id.showReviews);
    }


    public void openDialog(){

        DialogClass popup = new DialogClass();
        popup.show(getSupportFragmentManager(), "dialog");

    }

    @Override
    public void applyTexts(String reviews) {
        setReviews(reviews);
        ArrayAdapter adapter2 = new ArrayAdapter(Recipe.this, android.R.layout.activity_list_item, getReviews());
        instruc.setAdapter(adapter2);
    }
}
