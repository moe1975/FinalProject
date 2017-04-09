package com.moe.finalproject;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.moe.finalproject.R;

/**
 * Created by Moe on 2017-04-06.
 */

public class BlindingDetails extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_blinding_details);

        Bundle data = this.getIntent().getExtras();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Blinding bl = new Blinding();
        bl.setArguments(data);

        ft.replace(R.id.blindingFrame, bl);
        ft.commit();


    }

}
