package group22.seproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginRegister extends Activity {
    String filename = "./app/sampledata/users.txt/";
    String line = null;
    String[] lineSplit = new String[2];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);
        final EditText usernameInput = findViewById(R.id.username);
        final EditText passwordInput = findViewById(R.id.password);

        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent login = new Intent(LoginRegister.this, SearchResults.class);
                login.putExtra("username", usernameInput.getText().toString()); //information from box
                login.putExtra("password", passwordInput.getText().toString());

                //startActivity(resultsScreen); //Check login details
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //startActivity(registerAccount); //Go to register page
            }
        });
        /*
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                lineSplit = line.split(" ");
                System.out.println(lineSplit[1]);
            }
        }
        catch (IOException ex) {
            System.out.print("file not found");
        }
    */
    }
}
