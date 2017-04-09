package com.emad.finalproject;


import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.moe.finalproject.R;

import java.util.ArrayList;

public class Kitchen extends Adapter {

    final ArrayList<KitchenData> kitchenArray = new ArrayList<>();
    private SQLiteDatabase database;
    private KitchenAdapter kitchenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);

        database = getDbHelper().getWritableDatabase();

        final ListView listViewKitchen = (ListView) findViewById(R.id.kitchenList);
        kitchenAdapter = new KitchenAdapter(this);
        listViewKitchen.setAdapter(kitchenAdapter);

        kitchenArray.add(new KitchenData(0, "Front Light1", "@drawable/light"));
        kitchenArray.add(new KitchenData(1, "Fridge Light1", "@drawable/fridge"));
        kitchenArray.add(new KitchenData(2, "Microwave Light1", "@drawable/microwave"));
        kitchenAdapter.notifyDataSetChanged();

        listViewKitchen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){

                    case 0:
                        Intent lights = new Intent(Kitchen.this, KitchenLights.class);
                        startActivity(lights);
                        break;

                    case 1:
                        Intent fridge = new Intent(Kitchen.this, KitchenFridge.class);
                        startActivity(fridge);
                        break;

                    case 2:
                        Intent temp = new Intent(Kitchen.this, KitchenMicrowave.class);
                        startActivity(temp);
                        break;
                }

            }
        });
    }

    private class KitchenAdapter extends ArrayAdapter<KitchenData> {

        public KitchenAdapter(Context context) {

            super(context, 0);
        }

        public int getCount() {

            return kitchenArray.size();
        }

        public long getItemId(int position) {

            return kitchenArray.get(position).get_id();
        }

        public KitchenData getItem(int position) {

            return kitchenArray.get(position);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = Kitchen.this.getLayoutInflater();
            View result = null;
            result = inflater.inflate(R.layout.kitchen_row, null);

            Drawable res = getResources().getDrawable(getResources().
                    getIdentifier(kitchenArray.get(position).
                    getUri(), null, getPackageName()), null);

            ImageView image = (ImageView) result.findViewById((R.id.textKitchenItem));
            image.setImageDrawable(res);
            return result;
        }
    }
}