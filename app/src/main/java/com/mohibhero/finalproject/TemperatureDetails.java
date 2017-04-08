package com.mohibhero.finalproject;

/**
 * Created by MohibHero on 4/4/17.
 */


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.moe.finalproject.R;

public class TemperatureDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_details);

        Bundle data = this.getIntent().getExtras();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        TemperatureFragment f = new TemperatureFragment();
        f.setArguments(data);

        ft.replace(R.id.emptyFrame, f);
        ft.commit();
    }


}
