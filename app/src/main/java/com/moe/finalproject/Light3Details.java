package com.moe.finalproject;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.moe.finalproject.R;

public class Light3Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light3_details);

        Bundle data = this.getIntent().getExtras();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Light3 light3 = new Light3();

        light3.setArguments(data);

        ft.replace(R.id.lightFrame3, light3);
        ft.commit();
    }
}
