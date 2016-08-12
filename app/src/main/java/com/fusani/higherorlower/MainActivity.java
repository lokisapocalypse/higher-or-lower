package com.fusani.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    protected int number;

    public void checkGuess(View view) {
        EditText numberField = (EditText) findViewById(R.id.numberField);
        String message = "";
        int guess = 0;

        try {
            guess = Integer.parseInt(numberField.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Please enter a number", Toast.LENGTH_LONG).show();
            return;
        }

        if (guess == this.number) {
            message = "Correct!";
        } else if (guess < this.number) {
            message = "Higher!";
        } else {
            message = "Lower!";
        }

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void resetNumber(View view) {
        Random generator = new Random();
        this.number = generator.nextInt(10) + 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Random generator = new Random();
        this.number = generator.nextInt(10) + 1;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
