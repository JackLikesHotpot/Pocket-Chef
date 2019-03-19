package group22.seproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Recipe extends AppCompatActivity {

    TextView txtname;
    TextView txtduration;
    TextView txtcalories;
    ListView ingred;
    ListView instruc;
    RatingBar stars;
    Button submitbutton;


    private ArrayList<String> instructions = new ArrayList<String>();
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private double totalcalories;
    private double duration;
    private String name;

    private double averageRating;
    private int totalVotes;
    private double totalRating;

    public Recipe(String recipeName, ArrayList<Ingredient> ingreds, ArrayList<String> instructs, double totalcalories, double duration) {

        this.name = recipeName;
        this.instructions = instructs;
        this.ingredients = ingreds;
        this.totalcalories = totalcalories;
        this.duration = duration;
        this.averageRating = 0;
        this.totalVotes = 0;
        this.totalRating = 0;
    }


    /*

      NEW
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_front_page);
        txtname = (TextView) findViewById(R.id.rname);
        txtname.setText(name);


        txtduration = (TextView) findViewById(R.id.rduration);
        txtduration.setText("Duration: " + duration);


        txtcalories = (TextView) findViewById(R.id.rcalories);
        txtcalories.setText("Total Calories: " + totalcalories);


        ingred = (ListView) findViewById(R.id.listingredients);
        ArrayAdapter adapter = new ArrayAdapter(Recipe.this, android.R.layout.activity_list_item, ingredients);
        ingred.setAdapter(adapter);

        instruc = (ListView) findViewById(R.id.listinstructions);
        ArrayAdapter adapter1 = new ArrayAdapter(Recipe.this, android.R.layout.activity_list_item, instructions);
        instruc.setAdapter(adapter1);


        stars = (RatingBar) findViewById(R.id.ratingBar);
        submitbutton = (Button) findViewById(R.id.submit_button);
        submitbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
    }

/*
    public static void main(String[] args) {
        File f = new File(System.getProperty("user.dir") + "/app/sampledata/users.txt");
        System.out.println(f.exists());
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
    }
*/
    public ArrayList<String> getInstructions() {
        return instructions;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public double getTotalcalories() {
        return totalcalories;
    }

    public double getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int rating) {
        averageRating = totalRating / totalVotes;
    }

    public double getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(int rating) {
        totalRating += rating;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes() {
        totalVotes += 1;
    }
}
