package group22.seproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class SearchActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);
        final AutoCompleteTextView resultsBox = findViewById(R.id.search_box);
        Button nameSearch = findViewById(R.id.searchName);
        Button ingredientSearch = findViewById(R.id.searchIngredient);

        nameSearch.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent resultsScreen = new Intent(SearchActivity.this, SearchResults.class);
                resultsScreen.putExtra("search", resultsBox.getText().toString()); //information from box
                startActivity(resultsScreen);
            }
        });

        ingredientSearch.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent resultsScreen = new Intent(SearchActivity.this, SearchResults.class);
                resultsScreen.putExtra("search", resultsBox.getText().toString());
                startActivity(resultsScreen);
            }
        });

    }

}
