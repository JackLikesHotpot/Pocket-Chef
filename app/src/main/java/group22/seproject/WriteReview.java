package group22.seproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WriteReview extends Activity {

    private EditText writerev;
    private Button btn1;
    private Button btn2;
    private String review = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);

        writerev = (EditText) findViewById(R.id.editText);
        btn1 = (Button) findViewById(R.id.cancelbtn);
        btn2 = (Button)  findViewById(R.id.submitbtn);

        review = writerev.getText().toString();

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), recipePage.class);
                i.putExtra("value", review);
                startActivity(i);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent (v.getContext(), recipePage.class);
                startActivity(i2);
            }
        });

    }
}
