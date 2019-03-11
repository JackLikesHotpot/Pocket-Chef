package group22.seproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class recipePage extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_page);
        String message = getIntent().getStringExtra("name");

        TextView recipeName = findViewById(R.id.recipename);
        recipeName.setText(message);
    }
}
