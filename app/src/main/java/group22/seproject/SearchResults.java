package group22.seproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchResults extends Activity {

    ListView searchResultsLV;
    ArrayList<String> matchingRecipes = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    String searchedWord;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_results);
        searchResultsLV = findViewById(R.id.results_list);

        arrayAdapter = new ArrayAdapter<>(SearchResults.this, android.R.layout.simple_list_item_1, matchingRecipes);
        searchResultsLV.setAdapter(arrayAdapter);

        ArrayList<Recipe> recipeList = RecipeBook.getInstance().getRecipes();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////// IF THE USER CHOSE TO SEARCH BY RECIPE NAME //////////////////////////////////////////////////////////

       if(getIntent().getStringExtra("recipeName") != null) {

           searchedWord = getIntent().getStringExtra("recipeName");

           for(int i = 0; i < recipeList.size(); i++) {
               if(recipeList.get(i).getName().contains(searchedWord)) {
                   matchingRecipes.add(recipeList.get(i).getName());
               }
           }

       }

       ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////






        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////// IF THE USER CHOSE TO SEARCH BY INGREDIENT NAME //////////////////////////////////////////////////////////

       if(getIntent().getStringExtra("ingredName") != null) {
           searchedWord = getIntent().getStringExtra("ingredName");
           ArrayList<Ingredient> ingredientsList;
           Recipe currentRec;

           for(int i = 0; i < recipeList.size(); i++) {
               currentRec = recipeList.get(i);
               ingredientsList = currentRec.getIngredients();
               for(int j = 0; j < ingredientsList.size(); j++) {
                   if(ingredientsList.get(j).getName().contains(searchedWord)) {
                       matchingRecipes.add(currentRec.getName());
                       break;
                   }
               }
           }

       }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        if(matchingRecipes.size() == 0) {
            Toast noneFound = Toast.makeText(SearchResults.this, "No Recipes were found. Please try again.", Toast.LENGTH_LONG);
            noneFound.show();
        }




        searchResultsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 String itemName = searchResultsLV.getItemAtPosition(position).toString();

                Intent nextScreen = new Intent(SearchResults.this, recipePage.class);
                nextScreen.putExtra("recipeName", itemName);
                startActivity(nextScreen);
                }
            }
        );
    }
}
