package com.moe.finalproject;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.moe.finalproject.R;

/**
 * Created by Moe on 2017-04-06.
 */

public class LightDetails extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_light1_details);
        setContentView(R.layout.activity_light2_details);
        setContentView(R.layout.activity_light3_details);

        Bundle data = this.getIntent().getExtras();

        int deviceType = Integer.parseInt(data.getString("deviceType"));

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if(deviceType == RoomDataBase.item_Light1) {
            Light1 lg = new Light1();
            lg.setArguments(data);
            ft.replace(R.id.lightFrame, lg);
            ft.commit();
        } else if(deviceType == RoomDataBase.item_Light2) {
            Light2 lg2 = new Light2();
            lg2.setArguments(data);
            ft.replace(R.id.lightFrame, lg2);
            ft.commit();
        } else if(deviceType == RoomDataBase.item_Light3) {
            Light3 lg3 = new Light3();
            lg3.setArguments(data);
            ft.replace(R.id.lightFrame, lg3);
            ft.commit();
        }
    }

}
