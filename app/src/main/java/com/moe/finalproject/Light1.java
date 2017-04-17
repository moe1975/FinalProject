package com.moe.finalproject;

/**
 * Created by Moe on 2017-03-27.
 */

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
    private DatabaseHelper dbHelper;
    private int light1_status;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final Bundle data = this.getArguments();

        View v = inflater.inflate(R.layout.activity_light1, container, false);

        dbHelper = new DatabaseHelper(getActivity());

        final long device_id = Long.parseLong(data.getString("id"));

        Cursor cursor = dbHelper.getL1status(device_id);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            light1_status = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LIVINGROOM_LIGHT1_DEVICE_STATUS));

            cursor.moveToNext();
        }


        image = (ImageView) v.findViewById(R.id.lampsImage);

        /*image.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), getResources().getIdentifier(data.getString("itemImage"), null, getActivity().getPackageName())));*/

        lampText = (TextView) v.findViewById(R.id.lampsText);
        lampText.setText("ID: " + data.getString("ID") + " LIGHT OFF ");

        lightStatus = (Button) v.findViewById(R.id.switchLamp);
        quitLightApp = (Button) v.findViewById(R.id.quitLightButton);

        if(light1_status == 0) {
            lampText.setText("ID: " + data.getString("id") + " THE LIGHT IS OFF");
            lightStatus.setText("TURN LIGHT ON");
        } else {
            lampText.setText("ID: " + data.getString("id") + " THE LIGHT IS ON");
            lightStatus.setText("TURN LIGHT OFF");
        }

        lightStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!status) {
                    Toast.makeText(getActivity().getApplicationContext(), "THE LIGHT IS ON", Toast.LENGTH_SHORT).show();
                    lampText.setText("ID: " + data.getString("id") + " THE LIGHT IS ON");
                    lightStatus.setText("TURN LIGHT OFF");
                    dbHelper.saveL1status(1, device_id);
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "THE LIGHT IS OFF", Toast.LENGTH_SHORT).show();
                    lampText.setText("ID: " + data.getString("id") + " THE LIGHT IS OFF");
                    lightStatus.setText("TURN LIGHT ON");
                    dbHelper.saveL1status(0, device_id);
                }
                status = !status;
            }
        });

        /*if(light1_status == 0) {
            lampText.setText("ID: " + data.getString("id") + " LIGHT OFF");
            lightStatus.setText("LIGHT ON");
            //dbHelper.saveL1status(0, device_id);
        } else {
            lampText.setText("ID: " + data.getString("id") + " LIGHT ON");
            lightStatus.setText("LIGHT OFF");
            //dbHelper.saveL1status(1, device_id);

        }

        lightStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!status) {
                    Toast.makeText(getActivity().getApplicationContext(), "THE LIGHT IS ON", Toast.LENGTH_SHORT).show();
                    lampText.setText("ID: " + data.getString("id") + " LIGHT ON");
                    lightStatus.setText("LIGHT OFF");
                    dbHelper.saveL1status(0, device_id);
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "THE LIGHT IS OFF", Toast.LENGTH_SHORT).show();
                    lampText.setText("ID: " + data.getString("id") + " LIGHT OFF");
                    lightStatus.setText("LIGHT ON");
                    dbHelper.saveL1status(1, device_id);
                }
                status = !status;
            }
        });*/

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
