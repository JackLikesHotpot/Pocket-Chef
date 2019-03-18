package group22.seproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class SearchActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final User user;
        setContentView(R.layout.activity_search);
        final AutoCompleteTextView resultsBox = findViewById(R.id.search_box);
        Button nameSearch = findViewById(R.id.searchName);
        Button ingredientSearch = findViewById(R.id.searchIngredient);
        final Button addRecipe = findViewById(R.id.addRecipe);
        String[] account = getIntent().getStringArrayExtra("account");

        if (account[2].equals("R")) {
            user = new RegisteredUser(account[0], account[1], "@");
        }
        else if (account[2].equals("A")) {
            user = new Admin(account[0], account[1], "@");
        }
        else {
            user = new UnregisteredUser();
        }

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

        addRecipe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println(user.getClass());
                if (user instanceof UnregisteredUser ) {
                    Toast toast = Toast.makeText(SearchActivity.this, "Unregistered users cannot add recipes!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Intent addPage = new Intent(SearchActivity.this, addRecipeForm.class);
                    startActivity(addPage);
                }

            }
        });
    }

}
