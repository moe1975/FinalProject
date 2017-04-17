package com.moe.finalproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Moe on 4/14/2017.
 */

public class BaseActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;


        @Override
        protected void onCreate(Bundle saveInstanceState){

            super.onCreate(saveInstanceState);
            dbHelper = new DatabaseHelper(this);

        }

        public DatabaseHelper getDbHelper(){

            return dbHelper;
        }

}
