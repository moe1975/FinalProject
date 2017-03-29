package com.moe.finalproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Moe on 2017-03-22..
 */

public class Adapter extends AppCompatActivity {
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DatabaseHelper(this);
    }

    public DatabaseHelper getDbHelper() { return  dbHelper; }

}
