package com.emad.finalproject;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.moe.finalproject.R;


public class KitchenFridge extends Adapter {

    private Button SubmitFridgeTemp;
    private Button SubmitFreezerTemp;

    private TextView textViewFgTemp;
    private TextView textViewFzTemp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen_fridge);


        textViewFgTemp = (TextView) findViewById(R.id.Fridge_text);
        // the result of the screen
        final TextView fridgeTempText = (TextView) findViewById(R.id.fridgeTempText);

        SubmitFridgeTemp = (Button)findViewById(R.id.submit_fg_temp);
        SubmitFridgeTemp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fridgeTempText.setText("Fridge Temprature is: " + textViewFgTemp.getText());
            }

        });



        textViewFzTemp = (TextView) findViewById(R.id.Freezer_text);
        final TextView freezerTempText = (TextView) findViewById(R.id.freezerTempText);

        SubmitFreezerTemp = (Button)findViewById(R.id.submit_fz_temp);
        SubmitFreezerTemp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                freezerTempText.setText("Freezer Temprature is: " + textViewFzTemp.getText());
            }

        });



    }




}
