package com.mohibhero.finalproject;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.moe.finalproject.R;

/**
 * Created by MohibHero on 4/5/17.
 */

public class WeatherForecastDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forecast_details);

        Bundle data = this.getIntent().getExtras();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        WeatherForecastFragment f = new WeatherForecastFragment();
        f.setArguments(data);

        ft.replace(R.id.weatherFrame, f);
        ft.commit();
    }
}
