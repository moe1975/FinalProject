package com.moe.finalproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.moe.finalproject.R;
import com.mohibhero.finalproject.HouseSettings;

// Created by Moe Abed
public class MainActivity extends AppCompatActivity {

    private Button LivingRoom;
    private Button Kitchen;
    private Button Home;
    private Button Automobile;

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

        Kitchen = (Button) findViewById(R.id.Kitchen);
        Kitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(MainActivity.this, com.emad.finalproject.Kitchen.class);
                startActivity(mainIntent);
            }
        });

        Home = (Button) findViewById(R.id.Home);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(MainActivity.this, HouseSettings.class);
                startActivity(mainIntent);
            }
        });

        Automobile = (Button) findViewById(R.id.Automobile);
        Automobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(MainActivity.this, null);
                startActivity(mainIntent);
            }
        });

    }


}