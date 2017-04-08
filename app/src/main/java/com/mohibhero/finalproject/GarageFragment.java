package com.mohibhero.finalproject;

import android.support.v4.app.Fragment;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.moe.finalproject.R;


public class GarageFragment extends Fragment {

    ToggleButton toggleButton1, toggleButton2;
    RelativeLayout garageDoor;

    ImageView iView, doorView , iViewLight;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_garage_fragment, container, false);

         doorView = (ImageView) v.findViewById(R.id.doorOpenClosed);
         iViewLight = (ImageView) v.findViewById(R.id.lightOnOff);
        iView = (ImageView) v.findViewById(R.id.lightOnOff);

        toggleButton1 = (ToggleButton)v.findViewById(R.id.toggleButton_light);
        toggleButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               lightClick(v);
            }
        });
        toggleButton2 =(ToggleButton)v.findViewById(R.id.toggleButton_door);
        toggleButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doorClick(v);
            }
        });
        garageDoor = (RelativeLayout) v.findViewById(R.id.activity_garage);

        return v;
    }


    public void lightClick(View view) {
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            on = false;
            iView.setImageResource(R.drawable.lighton);
            CharSequence text = "Light Bulb is On!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(getActivity(), text, duration);
            toast.show();
        } else {
            on = true;
            iView.setImageResource(R.drawable.lightoff);
            CharSequence text = "Light Bulb is Off!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(getActivity(), text, duration);
            toast.show();
        }

    }


    public void doorClick (View v) {
        boolean on = ((ToggleButton) v).isChecked();

        if (on) {
            on = false;
            doorView.setImageResource(R.drawable.dooropen);
            iViewLight.setImageResource(R.drawable.lighton);
            CharSequence text = "Garage Door is Open";
            int duration = Snackbar.LENGTH_SHORT;
            Snackbar snackBar = Snackbar.make(garageDoor, text, duration );
            snackBar.show();

        } else {
            on = true;
            doorView.setImageResource(R.drawable.doorclosed);
            iViewLight.setImageResource(R.drawable.lightoff);
            CharSequence text = "Garage Door is Closed";
            int duration = Snackbar.LENGTH_SHORT;
            Snackbar snackBar = Snackbar.make(garageDoor, text, duration );
            snackBar.show();

        }

    }





}
