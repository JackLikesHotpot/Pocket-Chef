package group22.seproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//Used on startup to create a file in the Android device to store sample user information.

public class writerFile extends Activity {
    FileOutputStream fis;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            fis = openFileOutput("users.txt", MODE_PRIVATE);     //creates file known as users, appends
            fis.write("BobboBuilder bu1ldth1ngs A ".getBytes());
            fis.write("NotAdmin eatsth1ngs R ".getBytes());
            fis.close();          //safe close
            Intent login = new Intent(writerFile.this, Login.class);
            startActivity(login);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
                }
            }
        }