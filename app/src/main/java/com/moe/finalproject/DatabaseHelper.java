package com.moe.finalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Moe on 2017-03-22.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    /* Database name and version number */
    private static final String DATABASE_NAME = "project.db";
    private static final int VERSION_NUM = 1;

    /* Living Room Table and Column Names */
    public static final String TABLE_ROOM_ITEMS = "roomItems";

    public static final String COLUMN_LIVING_ROOM_ID = "_id";
    public static final String COLUMN_LIVING_ROOM_DEVICE_TYPE = "deviceType";
    public static final String COLUMN_LIVING_ROOM_DEVICE_TITLE = "deviceTitle";
    public static final String COLUMN_LIVING_ROOM_DEVICE_IMAGE = "deviceImage";
    public static final String COLUMN_LIVING_ROOM_LAST_VISITED = "lastVisited";
    public static final String COLUMN_LIVING_ROOM_CREATED = "created";

    //Automobile table and columns
    public static final String TABLE_AUTO_ITEMS = "autoItems";
    public static final String COLUMN_AUTO_ID = "_id";
    public static final String COLUMN_AUTO_NAME = "name";
    public static final String COLUMN_AUTO_DESCRIPTION = "description";

    // Database creation sql statement
    private static final String CREATE_ROOM_ITEMS_TABLE = "create table "
            + TABLE_ROOM_ITEMS + "( "
            + COLUMN_LIVING_ROOM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
            + COLUMN_LIVING_ROOM_CREATED + " int not null default 0, "
            + COLUMN_LIVING_ROOM_DEVICE_TITLE + " text not null, "
            + COLUMN_LIVING_ROOM_DEVICE_IMAGE + " text not null, "
            + COLUMN_LIVING_ROOM_LAST_VISITED + " INTEGER, "
            + COLUMN_LIVING_ROOM_CREATED + " INTEGER);";

    private static final String CREATE_AUTO_ITEMS = "create table " + TABLE_AUTO_ITEMS + " ( "
            + COLUMN_AUTO_ID + " integer primary key autoincrement, "
            + COLUMN_AUTO_NAME + " text, " + COLUMN_AUTO_DESCRIPTION + " text);";

    public DatabaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ROOM_ITEMS_TABLE);
        db.execSQL(CREATE_AUTO_ITEMS);
        Log.i("ChatDatabaseHelper", "Calling onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROOM_ITEMS);
        db.execSQL("drop table if exists " + TABLE_AUTO_ITEMS);
        onCreate(db);

        Log.i("DatabaseHelper", "Calling onUpgrade, oldVersion=" + oldVersion + " newVersion=" + newVersion);
    }
}