package com.moe.finalproject;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
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
    private Button quitLightApp;
    private Button bluelight;
    private Button yellowlight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        data = this.getArguments();
        setHasOptionsMenu(true);

        View v = inflater.inflate(R.layout.activity_light3, container, false);

        image = (ImageView) v.findViewById(R.id.lampImage);
        image = (ImageView) v.findViewById(R.id.lampImage);


        image.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), getResources().getIdentifier(data.getString("itemImage"), null, getActivity().getPackageName())));

        lampText = (TextView) v.findViewById(R.id.lampsText);
        lampText.setText("ID: " + data.getString("id") + " Lamp OFF ");

        lightStatus = (Button) v.findViewById(R.id.switchLamp);
        quitLightApp = (Button) v.findViewById(R.id.quitLightButton);

        bluelight = (Button) v.findViewById(R.id.bluelight);
        yellowlight = (Button) v.findViewById(R.id.yellowlight);

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

        bluelight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!status){
                    Toast.makeText(getActivity().getApplicationContext(), "You turned the blue light ON", Toast.LENGTH_SHORT).show();
                    bluelight.setText("Light Is OFF");

                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "You turned the blue light OFF", Toast.LENGTH_SHORT).show();
                    bluelight.setText("SWITCH LAMP ON");
                }
            }
        });

        yellowlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!status){
                    Toast.makeText(getActivity().getApplicationContext(), "You turned the yellow light ON", Toast.LENGTH_SHORT).show();
                    yellowlight.setText("Light Is OFF");
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "You turned the yellow light OFF", Toast.LENGTH_SHORT).show();
                    yellowlight.setText("SWITCH LAMP ON");
                }
            }
        });

        quitLightApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertdialog = new AlertDialog.Builder(getActivity());
                alertdialog.setMessage("Do you want to quit the Light App").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                getActivity().finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertdialog.create();
                alertDialog.show();
            }
        });

        return v;
    }
}
