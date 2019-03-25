package group22.seproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

//AdminOptions give a number of options available to an Admin. Currently only allows the Admin to verify recipes.

public class AdminOptions extends Activity {

    ListView verifyRecipes;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_screen);

        verifyRecipes = findViewById(R.id.verifyRecsLV);
        final ArrayList<Recipe> items = RecipeBook.getInstance().getPendingRecipes();
        ArrayList<String> recipeName = new ArrayList<String>();

        for (int i = 0; i < items.size(); i++) {
            recipeName.add(items.get(i).getName());
        }

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AdminOptions.this, android.R.layout.simple_list_item_1, recipeName);

        verifyRecipes.setAdapter(arrayAdapter);     //display pending recipes

        verifyRecipes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedRecName = verifyRecipes.getItemAtPosition(position).toString();


                for(int i = 0; i < items.size(); i++) {
                    if(items.get(i).getName().equals(selectedRecName)) {
                        Intent verifyRecPage = new Intent(AdminOptions.this, verifyRecipe.class);
                        verifyRecPage.putExtra("RecipeName", items.get(i).getName());
                        startActivity(verifyRecPage);
                    }
                }

            }


        });


    }
}
