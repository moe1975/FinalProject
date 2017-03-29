package com.talal.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * main activity class
 */

public class MainActivity extends AppCompatActivity {

    private Button automobile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        automobile = (Button) findViewById(R.id.Automobile);
        automobile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Automobile.class);
                startActivity(intent);
            }
        });


    }
}
