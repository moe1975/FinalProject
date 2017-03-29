package com.mohibhero.finalproject;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.example.moe.finalproject.R;


public class GarageDoor extends AppCompatActivity {

    ToggleButton toggleButton1, toggleButton2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage);

        toggleButton1 = (ToggleButton)findViewById(R.id.toggleButton_light);
        toggleButton2 =(ToggleButton)findViewById(R.id.toggleButton_door);
    }


    public void lightClick(View view) {
        boolean on = ((ToggleButton) view).isChecked();
        ImageView iView = (ImageView) findViewById(R.id.lightOnOff);
        if (on) {
            on = false;
            iView.setImageResource(R.drawable.lighton);
        } else {
            on = true;
            iView.setImageResource(R.drawable.lightoff);
        }

    }


    public void doorClick (View v) {
        boolean on = ((ToggleButton) v).isChecked();
        ImageView iView = (ImageView) findViewById(R.id.doorOpenClosed);
        ImageView iViewLight = (ImageView) findViewById(R.id.lightOnOff);
        if (on) {
            on = false;
            iView.setImageResource(R.drawable.dooropen);
            iViewLight.setImageResource(R.drawable.lighton);

        } else {
            on = true;
            iView.setImageResource(R.drawable.doorclosed);
            iViewLight.setImageResource(R.drawable.lightoff);
        }

    }


    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.toolbar_garage, m);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem mi) {
        int id = mi.getItemId();
        switch (id) {
            case R.id.garage_goback:
                Log.d("Toolbar", "Option 1 selected");


                AlertDialog.Builder builder = new AlertDialog.Builder(GarageDoor.this);
                builder.setTitle("Do you want to go Main Menu?");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        finish();
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

                break;

        }
        return true;
    }


}
