package group22.seproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.util.ArrayList;

public class SearchActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ArrayList<Recipe> recipeList = RecipeBook.getInstance().getRecipes();

        final User user;
        setContentView(R.layout.activity_search);
        final AutoCompleteTextView resultsBox = findViewById(R.id.search_box);
        Button nameSearch = findViewById(R.id.searchName);
        Button ingredientSearch = findViewById(R.id.searchIngredient);
        final Button addRecipe = findViewById(R.id.addRecipe);
        String[] account = getIntent().getStringArrayExtra("account");
        final Button AdminOpt = findViewById(R.id.AdminOpt);

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
                String recipeName = resultsBox.getText().toString();
                Intent resultsScreen;
                for(int i = 0; i < recipeList.size(); i++) {
                    if (recipeList.get(i).getName().equalsIgnoreCase(recipeName)) {
                        resultsScreen = new Intent(SearchActivity.this, recipePage.class);
                        resultsScreen.putExtra("recipeName", resultsBox.getText().toString()); //information from box
                        startActivity(resultsScreen);
                    }
                    Toast notFound = Toast.makeText(SearchActivity.this, "Recipe by that name not found", Toast.LENGTH_SHORT);
                    notFound.show();
                }
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
               // System.out.println(user.getClass());
                if (user instanceof UnregisteredUser) {
                    Toast toast = Toast.makeText(SearchActivity.this, "Unregistered users cannot add recipes!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Intent addPage = new Intent(SearchActivity.this, AddRecipe.class);
                    startActivity(addPage);
                }

            }
        });

        AdminOpt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(user instanceof Admin) {
                    Intent adminOptionsPage = new Intent(SearchActivity.this, AdminOptions.class);
                    startActivity(adminOptionsPage);
                }

                else {
                    Toast toast = Toast.makeText(SearchActivity.this, "Unauthorised access. Admin users only.", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
    }

}
