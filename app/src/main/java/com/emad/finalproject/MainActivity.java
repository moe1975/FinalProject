package com.emad.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;


/**
 * main activity class
 */

public class MainActivity extends AppCompatActivity {

    private Button Kitchen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Kitchen = (Button) findViewById(R.id.Kitchen);
        Kitchen.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Kitchen.class);
                startActivity(intent);
            }
        });


    }
}
