package group22.seproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class writerFile extends Activity {
    FileOutputStream fis;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            fis = openFileOutput("users.txt", MODE_PRIVATE);     //creates file known as users, appends
            fis.write("BobboBuilder bu1ldth1ngs A ".getBytes());
            fis.write("NotAdmin eatsth1ngs R ".getBytes());
            fis.close();          //safe close
            Intent login = new Intent(writerFile.this, LoginRegister.class);
            startActivity(login);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
                }
            }
        }