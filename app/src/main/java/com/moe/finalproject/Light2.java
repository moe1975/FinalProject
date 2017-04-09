package com.moe.finalproject;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moe.finalproject.R;


/**
 * Created by Moe on 2017-04-08.
 */

public class Light2 extends Fragment {

    private ImageView image;
    private TextView lampText;
    private Button lightStatus;
    private Button quitLightApp;
    private boolean status = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final Bundle data = this.getArguments();

        View v = inflater.inflate(R.layout.activity_light2, container, false);

        SeekBar seek = (SeekBar)v.findViewById(R.id.light2Seek);

        image = (ImageView) v.findViewById(R.id.lampsImage);

        image.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), getResources().getIdentifier(data.getString("itemImage"), null, getActivity().getPackageName())));

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                image.setImageBitmap(SetBrightness(BitmapFactory.decodeResource(getResources(), R.drawable.lamp), progresValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        lampText = (TextView) v.findViewById(R.id.switchLamp);
        lampText.setText("ID: " + data.getString("id") + " LIGHT OFF ");

        lightStatus = (Button) v.findViewById(R.id.switchLamp);
        quitLightApp = (Button) v.findViewById(R.id.quitLightButton);


        lightStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!status) {
                    Toast.makeText(getActivity().getApplicationContext(), " LIGHT IS ON", Toast.LENGTH_SHORT).show();
                    lampText.setText("ID: " + data.getString("id") + " LIGHT ON");
                    lightStatus.setText("LIGHT OFF");
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "You turned the light OFF", Toast.LENGTH_SHORT).show();
                    lampText.setText("ID: " + data.getString("ID") + " LIGHT OFF");
                    lightStatus.setText("SWITCH LIGHT ON");
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