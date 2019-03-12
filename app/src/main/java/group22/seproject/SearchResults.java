package group22.seproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchResults extends Activity {

    ListView search;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_results);

        System.out.println(getIntent().getStringExtra("search"));

        search = findViewById(R.id.results_list); //forgot what this did
        ArrayList<String> results = new ArrayList<String>();
        //SEARCH + PULL RESULTS FROM RECIPEBOOK HERE.

        results.add("YEET1");  //temp
        results.add("YEET2");
        final ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(SearchResults.this, R.layout.results_textview, R.id.textView, results);
        //display the arraylist in this format, context here, layout is a textview in an xml, textview id

        search.setAdapter(arrayAdapter);
        search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 String itemName = ((TextView) view.findViewById(R.id.textView)).getText().toString();
                 //get item name in listview and convert it to a string

                Intent nextScreen = new Intent(SearchResults.this, recipePage.class);
                nextScreen.putExtra("name", itemName);
                startActivity(nextScreen);
                }
            }
        );
    }
}
