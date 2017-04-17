package com.moe.finalproject;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.moe.finalproject.R;

public class Light2Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light2_details);

        Bundle data = this.getIntent().getExtras();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Light2 light2 = new Light2();

        light2.setArguments(data);

        ft.replace(R.id.lightFrame2, light2);
        ft.commit();
    }
}
