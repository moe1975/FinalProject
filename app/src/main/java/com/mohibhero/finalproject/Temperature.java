package com.mohibhero.finalproject;


import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moe.finalproject.R;

public class Temperature extends BaseActivity {
    private ImageView imageView;
    private TextView textView;
    private Button setTemprature;
    private EditText temperatureData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_temperature);

        getSupportActionBar().setTitle("Temprature Inside HouseSettings");

        final Bundle data = this.getIntent().getExtras();


        imageView = (ImageView) findViewById(R.id.tempInImage);

        imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), getResources().getIdentifier(data.getString("itemImage"), null, getPackageName())));

        textView = (TextView) findViewById(R.id.tempInTitle);
        temperatureData = (EditText) findViewById(R.id.tempInData);
        setTemprature = (Button) findViewById(R.id.addTemprature);

        setTemprature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temperatureData.getText().length() != 0) {
                    textView.setText("Temprature ID: " + data.getString("id") + " Current Temprature: " + temperatureData.getText().toString() + " \u2103");
                }
            }
        });

    }
}
