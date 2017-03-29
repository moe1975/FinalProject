package com.talal.finalproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Automobile extends com.talal.finalproject.Adapter {

    final ArrayList<AutomobileData> automobileArray = new ArrayList<>();

    private AutoMobileAdapter autoMobileAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automobile);



        final ListView listViewAutoMobile = (ListView) findViewById(R.id.automobileList);
        autoMobileAdapter = new AutoMobileAdapter(this);
        listViewAutoMobile.setAdapter(autoMobileAdapter);

        automobileArray.add(new AutomobileData(0, "Front Lights", "@drawable/lights"));

        automobileArray.add(new AutomobileData(0, "Front Lights", "@drawable/radio1"));

        automobileArray.add(new AutomobileData(0, "Front Lights", "@drawable/temperature"));

        automobileArray.add(new AutomobileData(0, "Front Lights", "@drawable/gps"));


        autoMobileAdapter.notifyDataSetChanged();


        listViewAutoMobile.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0){
                    Intent lights = new Intent(Automobile.this, AutomobileLights.class);
                    startActivity(lights);
                }
                else if (position == 1){
                    Intent radio = new Intent(Automobile.this, AutomobileRadio.class);
                    startActivity(radio);
                }
                else if (position == 2){
                    Intent temp = new Intent(Automobile.this, AutomobileTemperature.class);
                    startActivity(temp);
                }
                else if (position == 3){
                    Intent gps = new Intent(Automobile.this, AutomobileGPS.class);
                    startActivity(gps);
                }

            }
        });
    }


    private class AutoMobileAdapter extends ArrayAdapter<AutomobileData> {

        public AutoMobileAdapter(Context context) {
            super(context, 0);
        }

        public int getCount() {
            return automobileArray.size();
        }

        public long getItemId(int position) {
            return automobileArray.get(position).get_id();
        }

        public AutomobileData getItem(int position) {
            return automobileArray.get(position);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = Automobile.this.getLayoutInflater();
            View result = null;
            result = inflater.inflate(R.layout.automobile_row, null);


            Drawable res = getResources().getDrawable(getResources().getIdentifier(automobileArray.get(position).getUri(), null, getPackageName()), null);
            ImageView image = (ImageView) result.findViewById((R.id.textAutoMobileItem));
            image.setImageDrawable(res);
            return result;
        }
    }
}
