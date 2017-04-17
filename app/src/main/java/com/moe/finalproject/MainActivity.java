package com.moe.finalproject;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    private Toolbar mainTool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainTool = (Toolbar) findViewById(R.id.main_activity_toolbar);
        setSupportActionBar(mainTool);


/*
      LivingRoom = (Button) findViewById(R.id.LivingRoom);
        LivingRoom.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                // replace null with our main application activity
               Intent intent = new Intent(MainActivity.this,LivingRoom.class);
               startActivity(intent);
            }
       });

        Kitchen = (Button) findViewById(R.id.Kitchen);
        Kitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.emad.finalproject.Kitchen.class);
               startActivity(intent);
            }
        });

        Home = (Button) findViewById(R.id.Home);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HouseSettings.class);
                startActivity(intent);
            }
        });

        Automobile = (Button) findViewById(R.id.Automobile);
        Automobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // replace null with our main application activity
               Intent intent = new Intent(MainActivity.this, null);
                startActivity(intent);
          }
      });
*/


        }

    public void aboutDialog(){
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(this).setCancelable(false);
        alertdialog.setTitle("About");
        alertdialog.setMessage("House app (Final project for Android.\n" +
                "\nLiving Room :- Contains TV, Lights & Blindings. Created by Muhammed Abed\n"
        +"Kitchen: - Contains Fridge, Lights & Microwave. Created by Emad Abdel Mogith\n"
        +"House Settings: - Contains Garage Door, Lights & Weather Forecast. Created By Mohib Wajid\n"
        +"Garage(Automobile): - Contains information on GPS, Temperature etc. for Cars. Created By Talal Qasem.");
        alertdialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertdialog.create();
        alertDialog.show();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu m){
        getMenuInflater().inflate(R.menu.main_toolbar, m);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem menuItem){
        Intent intent = null;
        switch(menuItem.getItemId()){

            case R.id.living_room:
                intent = new Intent(MainActivity.this, LivingRoom.class);
                startActivity(intent);
                return true;
            case R.id.kitchen:
                intent = new Intent(MainActivity.this, com.emad.finalproject.Kitchen.class);
                startActivity(intent);
                return true;
            case R.id.house_setting:
                intent = new Intent(MainActivity.this, HouseSettings.class);
                startActivity(intent);
                return true;
            case R.id.garage:
                intent = new Intent(MainActivity.this, null);
                startActivity(intent);
                return true;
            case R.id.about:
                aboutDialog();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }




}
