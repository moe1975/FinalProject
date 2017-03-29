package com.moe.finalproject;

/**
 * Created by Moe on 2017-03-27.
 */

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moe.finalproject.R;


public class TV extends Adapter {

    private ImageView image;
    private TextView tvText;
    private Button addChannel;
    private EditText channelData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tv);

        getSupportActionBar().setTitle("Samsung TV");

        final Bundle data = this.getIntent().getExtras();


        image = (ImageView) findViewById(R.id.tvImage);

        image.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), getResources().getIdentifier(data.getString("itemImage"), null, getPackageName())));

        tvText = (TextView) findViewById(R.id.tvText);
        tvText.setText("TV ID: " + data.getString("id") + " TV Is Off ");

        channelData = (EditText) findViewById(R.id.channelTitle);
        addChannel = (Button) findViewById(R.id.addChannel);

        addChannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Channel channel = new Channel();

                if(channelData.getText().length() != 0) {
                    //channel.setChannel_name(channelData.getText().toString());
                    tvText.setText("TV ID: " + data.getString("id") + " Playing " + channelData.getText().toString());
                }
            }
        });

    }
}