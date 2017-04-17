package com.moe.finalproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.moe.finalproject.R;

// Created by Moe Abed
public class MainActivity extends AppCompatActivity {

    private Button LivingRoom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       LivingRoom = (Button) findViewById(R.id.LivingRoom);
        LivingRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(MainActivity.this,LivingRoom.class);
                startActivity(mainIntent);
            }
        });



    }


}