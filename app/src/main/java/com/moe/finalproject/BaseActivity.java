package com.moe.finalproject;

/**
 * Created by Moe on 2017-04-06.
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mohibhero.finalproject.ProjectDatabaseHelper;


public class BaseActivity extends AppCompatActivity {
    ProjectDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new ProjectDatabaseHelper(this);
    }

    public ProjectDatabaseHelper getDbHelper() { return  dbHelper; }

}