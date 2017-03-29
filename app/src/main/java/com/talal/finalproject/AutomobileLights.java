package com.talal.finalproject;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class AutomobileLights extends Adapter {

    final ArrayList<AutomobileData> automobileLightsArray = new ArrayList<>();
    private Switch Front_Light;
    private Switch High_Beam;
    private Switch Fog_Light;
    private SeekBar Interior_Light;
    private SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automobile_lights);

        database = getDbHelper().getWritableDatabase();

        Front_Light = (Switch) findViewById(R.id.front_light);
        Front_Light.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CharSequence text = "Low Beam Light is Off";
                int duration = Toast.LENGTH_LONG;
                if (Front_Light.isChecked()) {
                    text = "Low Beam Light is On";
                    duration = Toast.LENGTH_SHORT;
                }
                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                toast.show();
            }
        });

        High_Beam = (Switch) findViewById(R.id.high_beam);
        High_Beam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CharSequence text = "High Beam Light is Off";
                int duration = Toast.LENGTH_LONG;
                if (High_Beam.isChecked()) {
                    text = "High Beam Light is On";
                    duration = Toast.LENGTH_SHORT;
                }
                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                toast.show();
            }
        });

        Fog_Light = (Switch) findViewById(R.id.fog_light);
        Fog_Light.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CharSequence text = "Fog Light is Off";
                int duration = Toast.LENGTH_LONG;
                if (Fog_Light.isChecked()) {
                    text = "Fog Light is On";
                    duration = Toast.LENGTH_SHORT;
                }
                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                toast.show();
            }
        });

        Interior_Light = (SeekBar) findViewById(R.id.interior_L);

        Interior_Light.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            int progressChanged = 0;

            public void onProgressChanged( SeekBar seekbar, int progress, boolean fromUser){
                progressChanged = progress;
            }

            public void onStartTrackingTouch(SeekBar seekbar){}

            public void onStopTrackingTouch(SeekBar seekbar){
                Toast.makeText(AutomobileLights.this, "Light Level: " + progressChanged, Toast.LENGTH_SHORT).show();
            }

        });

    }

}


// Drawable res = getResources().getDrawable(getResources().getIdentifier("@drawable/front_light", null, getPackageName()));
//ImageView image = (ImageView)findViewById(R.id.imageView);
//image.setImageDrawable(res);
