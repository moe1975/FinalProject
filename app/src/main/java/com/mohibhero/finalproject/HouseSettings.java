package com.mohibhero.finalproject;


import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.moe.finalproject.R;

import java.util.ArrayList;

public class HouseSettings extends BaseActivity {


    private ListView HouseListView;
    private ArrayList<HouseDataBase> ItemsInHouse;
    private HouseAdapter HouseAdapter;



    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_house);

        getSupportActionBar().setTitle("House Settings");

        ItemsInHouse = new ArrayList<>();

        HouseListView = (ListView) findViewById(R.id.houseItems);
final boolean isTablet = findViewById(R.id.houseFrame)!= null;

        db = getDbHelper().getWritableDatabase();

        HouseAdapter = new HouseAdapter(this);

        HouseListView.setAdapter(HouseAdapter);

        ItemsInHouse.add(new HouseDataBase(0, "GarageFragment", "@drawable/garage"));
        ItemsInHouse.add(new HouseDataBase(1, "Temprature", "@drawable/temperature"));
        ItemsInHouse.add(new HouseDataBase(2, "WeatherForecastFragment", "@drawable/summer"));

        HouseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                Object o = HouseListView.getItemAtPosition(position);
                HouseDataBase str = (HouseDataBase) o;
                Bundle data = new Bundle();

                data.putString("id", Long.toString(id));
                data.putString("itemTitle", ItemsInHouse.get(position).getTitle());
                data.putString("itemImage", ItemsInHouse.get(position).getImageUri());

                Intent intent = null;


                if(!isTablet) {
                    if (position == 0)
                        intent = new Intent(HouseSettings.this, GarageDetails.class);

                    else if (position == 1)
                        intent = new Intent(HouseSettings.this, TemperatureDetails.class);
                    else if (position == 2)
                        intent = new Intent(HouseSettings.this, WeatherForecastDetails.class);


                    intent.putExtras(data);
                    startActivity(intent);
                }
                else{
                    Fragment f = null;
                    if (position == 0)
                        f = new GarageFragment();

                   else if (position == 1)
                       f = new TemperatureFragment();
                    else if (position == 2)
                        f = new WeatherForecastFragment();


                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();


                    ft.replace(R.id.houseFrame, f);
                    ft.commit();
                }

            }
        });
    }

    private class HouseAdapter extends ArrayAdapter<HouseDataBase> {

        public HouseAdapter(Context context) {
            super(context, 0);
        }

        public int getCount() {
            return ItemsInHouse.size();
        }

        public long getItemId(int position) {
            return ItemsInHouse.get(position).get_id();
        }

        public HouseDataBase getItem(int position) {
            return ItemsInHouse.get(position);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = HouseSettings.this.getLayoutInflater();
            View result = null;

            result = inflater.inflate(R.layout.house_settings_data_input, null);

            TextView HouseItemText = (TextView) result.findViewById((R.id.houseItemText));
            HouseItemText.setText(getItem(position).getTitle());

            ImageView HouseItemImage = (ImageView) result.findViewById((R.id.houseItemImage));
            HouseItemImage.setImageDrawable(ContextCompat.getDrawable(result.getContext(), getResources().getIdentifier(getItem(position).getImageUri(), null, getPackageName())));

            return result;
        }
    }
}
