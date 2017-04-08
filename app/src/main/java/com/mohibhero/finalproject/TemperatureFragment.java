package com.mohibhero.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.moe.finalproject.R;

import java.util.ArrayList;


public class TemperatureFragment extends Fragment {

    final ArrayList<TemperatureData> temperatureArray = new ArrayList<>();

    private TemperatureDatabaseHelper dbHelper;
    private SQLiteDatabase database;
    private String[] allColumns = { TemperatureDatabaseHelper.COLUMN_ID,
            TemperatureDatabaseHelper.COLUMN_TEMPERATURE };

    private TemperatureAdapter temperatureAdapter;

    Resources resources;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_temperature_fragment, container, false);

        Bundle data = this.getArguments();

        dbHelper = new TemperatureDatabaseHelper(getActivity());

        database = dbHelper.getWritableDatabase();

        readMessages();

        resources = getResources();
        final ListView listViewChat = (ListView) v.findViewById(R.id.listViewChat);
        temperatureAdapter = new TemperatureAdapter(getActivity());
        listViewChat.setAdapter(temperatureAdapter);
        final EditText editTextChat = (EditText) v.findViewById(R.id.tempInData);
        Button buttonSend = (Button) v.findViewById(R.id.addTemprature);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chatString = editTextChat.getText().toString();
                writeMessages(chatString);

                editTextChat.setText("");
            }
        });


        listViewChat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, final int position, final long id) {

                Object o = listViewChat.getItemAtPosition(position);
                final TemperatureData str=(TemperatureData)o;
                Bundle data = new Bundle();



                AlertDialog.Builder alertdialog = new AlertDialog.Builder(getActivity());
                alertdialog.setMessage("Do you want to remove the temperature from the database").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                  deleteMessage(id,position );

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

    private void readMessages() {
        // read database and save messages into the array list
        Cursor cursor = database.query(TemperatureDatabaseHelper.TABLE_MESSAGES,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String message = cursor.getString(cursor.getColumnIndex( TemperatureDatabaseHelper.COLUMN_TEMPERATURE));
            long id = cursor.getLong(cursor.getColumnIndex(TemperatureDatabaseHelper.COLUMN_ID));



            TemperatureData data = new TemperatureData(message, id);

            temperatureArray.add(data);
            cursor.moveToNext();
        }


        // close the cursor
        cursor.close();
    }

    private void writeMessages(String message) {
        ContentValues values = new ContentValues();

        values.put(TemperatureDatabaseHelper.COLUMN_TEMPERATURE, message);
        long id = database.insert(TemperatureDatabaseHelper.TABLE_MESSAGES, null,
                values);

        TemperatureData data = new TemperatureData(message, id);
        temperatureAdapter.notifyDataSetChanged();
        temperatureArray.add(data);

    }

    public void deleteMessage(long id, int position) {
        database.delete(TemperatureDatabaseHelper.TABLE_MESSAGES, "_id=?",
                new String[]{Long.toString(temperatureArray.get(position).get_id())});

        temperatureArray.remove(position);
        temperatureAdapter.notifyDataSetChanged();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 5) {
            Bundle extras = data.getExtras();
            int id = Integer.parseInt(extras.getString("id"));

            database.delete(TemperatureDatabaseHelper.TABLE_MESSAGES, "_id=?",
                    new String[]{Long.toString(temperatureArray.get(id).get_id())});

            temperatureArray.remove(id);
            temperatureAdapter.notifyDataSetChanged();
        }
    }

    private class TemperatureAdapter extends ArrayAdapter<TemperatureData> {

        public TemperatureAdapter(Context context) {
            super(context, 0);
        }

        public int getCount() {
            return temperatureArray.size();
        }

        public long getItemId(int position) { return temperatureArray.get(position).get_id();}
        public TemperatureData getItem(int position) {
            return temperatureArray.get(position);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View result = null;
            result = inflater.inflate(R.layout.temperature_row_incoming, null);


            TextView message = (TextView) result.findViewById((R.id.textChat));
            message.setText(getItem(position).getTemperature());
            return result;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        dbHelper.close();
    }
}


