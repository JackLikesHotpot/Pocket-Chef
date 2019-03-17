package group22.seproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Register extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText emailInput = findViewById(R.id.etEmail);
        final EditText usernameInput = findViewById(R.id.etUsername);
        final EditText passwordInput = findViewById(R.id.etPassword);
        final EditText passwordCheck = findViewById(R.id.etCPassword);
        Button bRegister = findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                String password2 = passwordCheck.getText().toString();
                String email = emailInput.getText().toString();

                boolean checked = detailsCheck(username, password, password2, email);
                if (checked == true) {
                    try {
                        registerDetails(username, password);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private boolean detailsCheck(String username, String password, String password2, String email) {
        boolean result = false;
        boolean hasInt = false;
        boolean hasSpace = false;
        boolean specialCh = false;
        int i = 0;

        //fix usernames to not be the same as passwords
        //fix usernames so that duplicates are not allowed - read entire file and ensure that username is not there

        if (!(password.equals(password2))) {
            //password is not the same
            Toast toast = Toast.makeText(Register.this,"Password is not the same as entered", Toast.LENGTH_SHORT);
            toast.show();
            result = false;
        }
        else if (password.length() < 8) {
            //short password
            Toast toast = Toast.makeText(Register.this,"Password length is shorter than 8 characters", Toast.LENGTH_SHORT);
            toast.show();
            result = false;
        }
        else {
            char[] charaPass = password.toCharArray();
            while (i < charaPass.length) {
                if (Character.isDigit(charaPass[i])) {
                    if (hasInt == false) {
                        hasInt = true;
                    }
                }
                if (Character.isWhitespace(charaPass[i])) {
                    hasSpace = true;
                }
                if (!(Character.isLetterOrDigit(charaPass[i]))) {
                    specialCh = true;
                }
                i++;
            }
            if ((specialCh == true) || (hasSpace == true) || (hasInt == false)) {
                if (specialCh == true) {
                    Toast toast = Toast.makeText(Register.this,"Your password contains an illegal character", Toast.LENGTH_SHORT);
                    toast.show();
                }
                if (hasSpace == true) {
                    Toast toast = Toast.makeText(Register.this,"Your password contains a space", Toast.LENGTH_SHORT);
                    toast.show();
                }
                if (hasInt == false) {
                    Toast toast = Toast.makeText(Register.this,"Your password contains no numbers", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else {
                result = true;
            }
        }
        return result;
    }

    private void registerDetails(String username, String password) throws IOException {

        try {
            FileOutputStream fis = openFileOutput("users.txt", MODE_APPEND);
            fis.write((username + " ").getBytes());
            fis.write((password + " ").getBytes());
            fis.write(("R ").getBytes());
            fis.close();
        }
        catch (Exception e) {
        }
    }
}
