package group22.seproject;

import android.app.Activity;
import android.content.Context;
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

    EditText et_text;
    Button b_write, b_read;
    TextView tv_text;

    FileOutputStream fis;

    protected void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.a_test);
        b_write = findViewById(R.id.b_write);
        b_read = findViewById(R.id.b_read);

        b_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    fis = openFileOutput("pasta.txt", MODE_PRIVATE);     //creates file known as users, appends
                    fis.write("pasta£".getBytes());
                    fis.write("131£".getBytes());
                    fis.write("20£".getBytes());
                    fis.write("pasta£".getBytes());
                    fis.write("water£".getBytes());
                    fis.write("1. Add pasta and water to a pot and boil£".getBytes());
                    fis.write("2. Drain it£".getBytes());
                    fis.write("3. Eat it£".getBytes());
                    fis.write("Very tasty!£".getBytes());
                    fis.close();          //safe close

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("BEGINNING READ");
                readFile();
            }
        });
    }
    public void readFile() {
        boolean isN = false;

        try {
            FileInputStream fin = openFileInput("pasta.txt");
            int c;              //c is an ASCII number.
            String temp = "";
            int n = 0;
            while ((c = fin.read()) != -1) {
                temp = temp + Character.toString((char) c);
            }
            String[] firstSplit = temp.split("£");

            while (n < firstSplit.length) {
                firstSplit[n] = firstSplit[n].substring(0, firstSplit[n].length()-1); //how recipes will look, reviews sep by another char

                if (firstSplit[n].charAt(firstSplit[n].length()-1) == ('Â')) {  //check that the last character isn't this
                    firstSplit[n] = firstSplit[n].substring(0, firstSplit[n].length()-1);
                }
                if ((Character.isDigit(firstSplit[n].charAt(0))) && ((firstSplit[n].charAt(1)) == ('.'))) {              //if the first char of the string is a number
                    isN = true;//actually check if the first string is an integer followed by a .
                }
                if (!(Character.isDigit(firstSplit[n].charAt(0))) && (isN == true)) {
                    System.out.println("REVIEWS"); //temp
                }
                System.out.println(firstSplit[n]);
                n++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }