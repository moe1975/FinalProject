package com.moe.finalproject;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.moe.finalproject.R;

/**
 * Created by Moe on 2017-04-05.
 */

public class TVDetails extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tv_details);

        Bundle data = this.getIntent().getExtras();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        TVFragment tv = new TVFragment();
        tv.setArguments(data);

        ft.replace(R.id.tvFrame, tv);
        ft.commit();


    }
}
