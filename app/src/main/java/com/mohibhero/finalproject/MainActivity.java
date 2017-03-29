package com.mohibhero.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by MohibHero on 3/28/17.
 */

public class MainActivity extends AppCompatActivity {

    private Button appThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appThree = (Button) findViewById(R.id.appThree);
        appThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HouseSettings.class);
                startActivity(intent);
            }
        });
    }



}

