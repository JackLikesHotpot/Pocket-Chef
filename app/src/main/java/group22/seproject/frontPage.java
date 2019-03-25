package group22.seproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//Front page for the application sets up the necessary storage files to run the app.

public class frontPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);
        Button redirect = findViewById(R.id.startButton);

        redirect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast = Toast.makeText(frontPage.this, "Loading app!", Toast.LENGTH_SHORT);
                toast.show();
                Intent init = new Intent(frontPage.this, writerFile.class);
                startActivity(init);
            }
        });
    }
}
