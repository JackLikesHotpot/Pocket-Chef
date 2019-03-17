package group22.seproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LoginRegister extends Activity {
    String username = "";
    String password = "";
    boolean loginTry = false;
    Context context = getBaseContext();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button loginButton = findViewById(R.id.bLogin);
        Button registerButton = findViewById(R.id.tvRegisterLink);
        final EditText usernameInput = findViewById(R.id.etUsername);
        final EditText passwordInput = findViewById(R.id.etPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                username = usernameInput.getText().toString();
                password = passwordInput.getText().toString();
                try {
                    loginTry = loginCheck(username, password);
                    if (loginTry == true) {
                        Toast toast = Toast.makeText(LoginRegister.this,"Redirecting to search...", Toast.LENGTH_SHORT);
                        toast.show();
                        Intent login = new Intent(LoginRegister.this, SearchActivity.class);
                        startActivity(login);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent register = new Intent(LoginRegister.this, Register.class);
                startActivity(register);
            }
        });
    }

    private boolean loginCheck(String username, String password) throws IOException {
        boolean returnLogin = false;
        boolean correctDetails = false;
        try {
            FileInputStream fin = openFileInput("users.txt");
            int c;              //c is an ASCII number.
            String temp = "";
            int n = 0;

            while ((c = fin.read()) != -1) {
                temp = temp + Character.toString((char) c); //temp is a character of the line
            }

            String[] lineSplit = temp.split(" ");
            while (n < lineSplit.length) {

                if ((lineSplit[n].equals(username)) && (lineSplit[n + 1].equals(password))) {
                    //correct username and password
                    Toast toast = Toast.makeText(LoginRegister.this,"Username and password correct!", Toast.LENGTH_SHORT);
                    toast.show();
                    correctDetails = true;
                    break;

                } else if ((lineSplit[n].equals(username)) && (!(lineSplit[n + 1].equals(password)))) {
                    //correct username, incorrect password
                    Toast toast = Toast.makeText(LoginRegister.this,"Password not recognised!", Toast.LENGTH_SHORT);
                    toast.show();
                    break;

                } else if (n == lineSplit.length-1) {
                    Toast toast = Toast.makeText(LoginRegister.this,"Username not recognised!", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }

                else {
                    n++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (correctDetails == true) {
            returnLogin = true;
        }
        return returnLogin;
    }
}