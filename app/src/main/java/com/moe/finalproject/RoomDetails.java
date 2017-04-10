package com.moe.finalproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.example.moe.finalproject.R;

/**
 * Created by Moe on 2017-04-09.
 */

public class RoomDetails extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livingroom_details);

        Bundle data = this.getIntent().getExtras();

        int itemType = Integer.parseInt(data.getString("itemType"));

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        Fragment f = null;

        if(itemType == RoomDataBase.item_TV) {
            f = new TVFragment();
        } else if(itemType == RoomDataBase.item_Light1) {
            f = new Light1();
        } else if(itemType == RoomDataBase.item_Light2) {
            f = new Light2();
        } else if(itemType == RoomDataBase.item_Light3) {
            f = new Light3();
        } else if(itemType == RoomDataBase.item_Blinding) {
            f = new Blinding();
        }

        f.setArguments(data);

        ft.replace(R.id.emptyFrame, f);
        ft.commit();
    }
}



