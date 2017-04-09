package com.moe.finalproject;

/**
 * Created by Moe on 2017-03-27.
 */

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


public class Light1 extends Fragment {
    private ImageView image;
    private TextView lampText;
    private Button lightStatus;
    private Button quitLightApp;
    private boolean status = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final Bundle data = this.getArguments();

        View v = inflater.inflate(R.layout.activity_light1, container, false);

        image = (ImageView) v.findViewById(R.id.lampsImage);

        image.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), getResources().getIdentifier(data.getString("itemImage"), null, getActivity().getPackageName())));

        lampText = (TextView) v.findViewById(R.id.lampsText);
        lampText.setText("ID: " + data.getString("ID") + " LIGHT OFF ");

        lightStatus = (Button) v.findViewById(R.id.switchLamp);
        quitLightApp = (Button) v.findViewById(R.id.quitLightButton);

        lightStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!status) {
                    Toast.makeText(getActivity().getApplicationContext(), "THE LIGHT IS ON", Toast.LENGTH_SHORT).show();
                    lampText.setText("ID: " + data.getString("id") + " LIGHT ON");
                    lightStatus.setText("LIGHT OFF");
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "THE LIGHT IS OFF", Toast.LENGTH_SHORT).show();
                    lampText.setText("ID: " + data.getString("id") + " LIGHT OFF");
                    lightStatus.setText("LIGHT ON");
                }
                status = !status;
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
