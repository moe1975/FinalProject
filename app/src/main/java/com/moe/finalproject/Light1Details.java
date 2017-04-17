package com.moe.finalproject;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.moe.finalproject.R;

public class Light1Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light1_details);

        Bundle data = this.getIntent().getExtras();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Light1 light1 = new Light1();

        light1.setArguments(data);

        ft.replace(R.id.lightFrame1, light1);
        ft.commit();
    }
}
