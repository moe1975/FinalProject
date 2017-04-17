package com.moe.finalproject;

import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
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
    private Button quitLightApp;
    private boolean status = false;
    private DatabaseHelper dbHelper;
    private int light3_status;
    private int light3_dimlevel;
    private int color_check;
    private Switch light_switch;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final Bundle data = this.getArguments();

        View v = inflater.inflate(R.layout.activity_light3, container, false);

        final long device_id = Long.parseLong(data.getString("id"));

        dbHelper = new DatabaseHelper(getActivity());

        Cursor cursor = dbHelper.getL3status(device_id);


        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            light3_status = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LIVINGROOM_LIGHT3_DEVICE_STATUS));
            light3_dimlevel = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LIVINGROOM_LIGHT3_DEVICE_DIM_LEVEL));
            color_check = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LIVINGROOM_LIGHT3_DEVICE_COLOR));


            cursor.moveToNext();
        }

        SeekBar seek = (SeekBar)v.findViewById(R.id.light3Seek);

        image = (ImageView) v.findViewById(R.id.lampsImage);

        //image.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), getResources().getIdentifier(data.getString("itemImage"), null, getActivity().getPackageName())));

        seek.setProgress(light3_dimlevel);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                image.setImageBitmap(SetBrightness(BitmapFactory.decodeResource(getResources(), R.drawable.lamp), progresValue));
                light3_dimlevel = progresValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                dbHelper.saveL3dimlevel(device_id, light3_dimlevel);
            }
        });



        lampText = (TextView) v.findViewById(R.id.switchLamp);
        lampText.setText("ID: " + data.getString("id") + " LIGHT OFF ");

        lightStatus = (Button) v.findViewById(R.id.switchLamp);
        quitLightApp = (Button) v.findViewById(R.id.quitLightButton);
        //changeLightButton = (ToggleButton) v.findViewById(R.id.lightChangeButton);


        if(light3_status == 0) {
            lampText.setText("ID: " + data.getString("id") + " THE LIGHT IS OFF");
            lightStatus.setText("TURN LIGHT ON");
            dbHelper.saveL3status(1, device_id);

        } else {
            lampText.setText("ID: " + data.getString("id") + " THE LIGHT IS ON");
            lightStatus.setText("TURN LIGHT OFF");
            dbHelper.saveL3status(0, device_id);

        }

        lightStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!status) {
                    Toast.makeText(getActivity().getApplicationContext(), "THE LIGHT IS ON", Toast.LENGTH_SHORT).show();
                    lampText.setText("ID: " + data.getString("id") + " THE LIGHT IS ON");
                    lightStatus.setText("TURN LIGHT OFF");
                    dbHelper.saveL3status(1, device_id);
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "THE LIGHT IS OFF", Toast.LENGTH_SHORT).show();
                    lampText.setText("ID: " + data.getString("id") + " THE LIGHT IS OFF");
                    lightStatus.setText("TURN LIGHT ON");
                    dbHelper.saveL3status(0, device_id);
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

       /* changeLightButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                int lightChangeStatus =0;
                if(lightChangeStatus==1){
                                 //lightChangeStatus = false;
                                image.setImageResource(R.drawable.bluelight);
                                changeLightButton.setText("Turn Light To Yellow");
                                dbHelper.saveL3color(device_id, 2);


                }
                else {
                    //lightChangeStatus = true;
                    image.setImageResource(R.drawable.lamp);
                    changeLightButton.setText("Turn Light To Blue");
                    dbHelper.saveL3color(device_id, 1);



                }

            }
        });*/

        light_switch = (Switch)v.findViewById(R.id.changeColor);

        light_switch.setChecked((color_check == 1) ? true : false);

        light_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CharSequence text = "Change Color To Blue";
                int duration = Toast.LENGTH_LONG;
                if (light_switch.isChecked()) {
                    text = "Back To Normal";
                    image.setImageResource(R.drawable.bluelight);
                    duration = Toast.LENGTH_SHORT;
                    dbHelper.saveL3color(device_id, 1);
                } else {
                    image.setImageResource(R.drawable.lamp);
                    dbHelper.saveL3color(device_id, 0);

                }
                Toast toast;
                toast = Toast.makeText(getActivity().getApplicationContext(), text, duration);
                toast.show();
            }
        });


        return v;
    }

    /*
    Code by http://shaikhhamadali.blogspot.ca/2013/07/set-brightness-of-imageincreasedecrease.html
     */
    public Bitmap SetBrightness(Bitmap src, int value) {
// original image size
        int width = src.getWidth();
        int height = src.getHeight();
// create output bitmap
        Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());
// color information
        int A, R, G, B;
        int pixel;

// scan through all pixels
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
// get pixel color
                pixel = src.getPixel(x, y);
                A = Color.alpha(pixel);
                R = Color.red(pixel);
                G = Color.green(pixel);
                B = Color.blue(pixel);

// increase/decrease each channel
                R += value;
                if (R > 255) {
                    R = 255;
                } else if (R < 0) {
                    R = 0;
                }

                G += value;
                if (G > 255) {
                    G = 255;
                } else if (G < 0) {
                    G = 0;
                }

                B += value;
                if (B > 255) {
                    B = 255;
                } else if (B < 0) {
                    B = 0;
                }
// apply new pixel color to output bitmap
                bmOut.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }

// return final image
        return bmOut;
    }
}