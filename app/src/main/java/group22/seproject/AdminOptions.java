package group22.seproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminOptions extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_screen);

        Button verify = findViewById(R.id.verifyRecipe);

        verify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //verify recipe
            }
        });
    }
}
