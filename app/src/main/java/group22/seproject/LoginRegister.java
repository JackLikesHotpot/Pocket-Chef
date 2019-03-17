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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button loginButton = findViewById(R.id.bLogin);
        Button registerButton = findViewById(R.id.tvRegisterLink);
        Button unregisterLogin = findViewById(R.id.tvUnregisteredUser);
        final EditText usernameInput = findViewById(R.id.etUsername);
        final EditText passwordInput = findViewById(R.id.etPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                username = usernameInput.getText().toString();
                password = passwordInput.getText().toString();
                String[] userDetails = new String[3];
                try {
                    userDetails = loginCheck(username, password);
                    if (userDetails[3] == "True") {
                        Toast toast = Toast.makeText(LoginRegister.this, "Success! Redirecting to search page...", Toast.LENGTH_SHORT);
                        toast.show();
                        Intent search = new Intent(LoginRegister.this, SearchActivity.class);
                        search.putExtra("account", userDetails);
                        startActivity(search);
                    }
                } catch (Exception e) {
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

        unregisterLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String[] userDetails = {"","","U","True"};
                Intent search = new Intent(LoginRegister.this, SearchActivity.class);
                search.putExtra("account", userDetails);
                startActivity(search);
            }
        });
    }

    private String[] loginCheck(String username, String password) throws IOException {
        String[] correctDetails = new String[4];
        boolean loginPass = false;
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
                    Toast toast = Toast.makeText(LoginRegister.this, "Username and password correct!", Toast.LENGTH_SHORT);
                    toast.show();
                    correctDetails[0] = lineSplit[n];
                    correctDetails[1] = lineSplit[n + 1];
                    correctDetails[2] = lineSplit[n + 2];
                    loginPass = true;
                    break;

                } else if ((lineSplit[n].equals(username)) && (!(lineSplit[n + 1].equals(password)))) {
                    //correct username, incorrect password
                    Toast toast = Toast.makeText(LoginRegister.this, "Password not recognised!", Toast.LENGTH_SHORT);
                    toast.show();
                    break;

                } else if (n == lineSplit.length - 1) {
                    Toast toast = Toast.makeText(LoginRegister.this, "Username not recognised!", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                } else {
                    n++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (loginPass == true) {
            correctDetails[3] = "True";
        }
        return correctDetails;
    }
}