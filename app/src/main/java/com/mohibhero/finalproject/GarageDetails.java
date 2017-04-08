package com.mohibhero.finalproject;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.moe.finalproject.R;

/**
 * Created by MohibHero on 4/5/17.
 */

public class GarageDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_details);

        Bundle data = this.getIntent().getExtras();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        GarageFragment f = new GarageFragment();
        f.setArguments(data);

        ft.replace(R.id.garageFrame, f);
        ft.commit();
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


                AlertDialog.Builder builder = new AlertDialog.Builder( this );

                builder.setTitle("Do you want to go House Settings Menu?");

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
