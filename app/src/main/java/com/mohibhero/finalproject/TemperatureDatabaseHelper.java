package com.mohibhero.finalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class TemperatureDatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_MESSAGES = "messages";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TEMPERATURE = "temperature";

    private static final String DATABASE_NAME = "TemperatureFragment.db";
    private static final int VERSION_NUM = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_MESSAGES + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_TEMPERATURE
            + " text not null);";

    public TemperatureDatabaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS messages");
        onCreate(db);
    }
}
