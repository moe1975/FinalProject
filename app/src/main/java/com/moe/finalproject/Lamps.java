package com.moe.finalproject;

/**
 * Created by Moe on 2017-03-27.
 */

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moe.finalproject.R;


public class Lamps extends Adapter {
    private ImageView image;
    private TextView lampText;
    private Button lightStatus;
    private boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lamps);

        getSupportActionBar().setTitle("Lamps");

        final Bundle data = this.getIntent().getExtras();


        image = (ImageView) findViewById(R.id.lampsImage);

        image.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), getResources().getIdentifier(data.getString("itemImage"), null, getPackageName())));

        lampText = (TextView) findViewById(R.id.lampsText);
        lampText.setText("ID: " + data.getString("id") + " Lamp OFF ");

        lightStatus = (Button) findViewById(R.id.switchLamp);

        lightStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!status) {
                    Toast.makeText(getApplicationContext(), "You turned the light ON", Toast.LENGTH_SHORT);
                    lampText.setText("ID: " + data.getString("id") + " Light ON");
                    lightStatus.setText("SWITCH LAMP OFF");
                } else {
                    Toast.makeText(getApplicationContext(), "You turned the light OFF", Toast.LENGTH_SHORT);
                    lampText.setText("ID: " + data.getString("id") + " Light OFF");
                    lightStatus.setText("SWITCH LAMP ON");
                }
                status = !status;
            }
        });

    }
}
