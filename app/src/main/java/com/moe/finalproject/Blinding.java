package com.moe.finalproject;

/**
 * Created by Moe on 2017-03-27..
 */

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moe.finalproject.R;

// yes


public class Blinding extends Fragment {
    private ImageView image;
    private TextView blindingText;
    private ProgressBar progressBar;
    private DatabaseHelper dbHelper;
    private ImageView blindup;
    private ImageView blinddown;
    private Switch blindswitch;
    private int blindcheck;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final Bundle data = this.getArguments();

        View v = inflater.inflate(R.layout.activity_blinding, container, false);
        final long device_id=Long.parseLong(data.getString("id"));
        dbHelper=new DatabaseHelper(getActivity());

        Cursor cursor =dbHelper.getBlindingstatus(device_id);

        cursor.moveToFirst();

        while(!cursor.isAfterLast()){

            blindcheck=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LIVINGROOM_BLINDING_DEVICE_STATUS));
            cursor.moveToNext();

        }



        blindswitch=(Switch)v.findViewById(R.id.blindingswitch);



        blindswitch.setChecked((blindcheck==1) ? true : false);
        blindswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            CharSequence txt = "blind closed";
             int dur = Toast.LENGTH_LONG;

             if(blindswitch.isChecked()){
                 txt = "blind is open";
                 dur = Toast.LENGTH_LONG;
                 dbHelper.saveBlindingstatus(1,device_id);

             }else{
                 dbHelper.saveBlindingstatus(0,device_id);

             }
              Toast toast = Toast.makeText(getActivity().getApplicationContext(),txt,dur);
             toast.show();
            }
        });


        progressBar = (ProgressBar) v.findViewById(R.id.progressLivingroomBar);
        progressBar.setVisibility(View.VISIBLE);
        image = (ImageView) v.findViewById(R.id.blindingImage);

       /* image.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), getResources().getIdentifier(data.getString("itemImage"), null, getActivity().getPackageName())));*/

        blindingText = (TextView) v.findViewById(R.id.blindingText);

        blindingText.setText("ID: " + data.getString("id"));

        return v;
    }
}
