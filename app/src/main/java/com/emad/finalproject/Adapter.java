package com.emad.finalproject;

/**
 * Created by Algo on 3/29/2017.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

    public class Adapter extends AppCompatActivity {
        DataBaseHelper dbHelper;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            dbHelper = new DataBaseHelper(this);
        }

        public DataBaseHelper getDbHelper() { return  dbHelper; }

    }
