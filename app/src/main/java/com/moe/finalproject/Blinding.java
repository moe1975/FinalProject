package com.moe.finalproject;

/**
 * Created by Moe on 2017-03-27.
 */

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moe.finalproject.R;


public class Blinding extends Adapter {
    private ImageView image;
    private TextView blindingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_blinding);

        getSupportActionBar().setTitle("House Blindings");

        final Bundle data = this.getIntent().getExtras();


        image = (ImageView) findViewById(R.id.blindingImage);

        image.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), getResources().getIdentifier(data.getString("itemImage"), null, getPackageName())));

        blindingText = (TextView) findViewById(R.id.blindingText);

        blindingText.setText("ID: " + data.getString("id"));

    }
}
