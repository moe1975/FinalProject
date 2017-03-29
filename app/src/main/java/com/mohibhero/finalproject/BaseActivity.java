package com.mohibhero.finalproject;

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

