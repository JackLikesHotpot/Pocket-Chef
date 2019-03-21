package group22.seproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class WriteReview extends Activity {

    private EditText writerev;
    String review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);

        writerev = (EditText) findViewById(R.id.editText);
        review = writerev.getText().toString();


    }
}
