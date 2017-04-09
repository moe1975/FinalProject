package com.moe.finalproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moe.finalproject.R;


/**
 * Created by Moe on 2017-04-08.
 */

public class Light3 extends Fragment {
    private ImageView image;
    private TextView lampText;
    private Button lightStatus;
    private boolean status = false;
    private Bundle data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        data = this.getArguments();
        setHasOptionsMenu(true);

        View v = inflater.inflate(R.layout.activity_light3, container, false);

        image = (ImageView) v.findViewById(R.id.lampsImage);

        image.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), getResources().getIdentifier(data.getString("itemImage"), null, getActivity().getPackageName())));

        lampText = (TextView) v.findViewById(R.id.lampsText);
        lampText.setText("ID: " + data.getString("id") + " Lamp OFF ");

        lightStatus = (Button) v.findViewById(R.id.switchLamp);

        lightStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!status) {
                    Toast.makeText(getActivity().getApplicationContext(), "You turned the light ON", Toast.LENGTH_SHORT).show();
                    lampText.setText("ID: " + data.getString("id") + " Light ON");
                    lightStatus.setText("SWITCH LAMP OFF");
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "You turned the light OFF", Toast.LENGTH_SHORT).show();
                    lampText.setText("ID: " + data.getString("id") + " Light OFF");
                    lightStatus.setText("SWITCH LAMP ON");
                }
                status = !status;
            }
        });

        return v;
    }
}