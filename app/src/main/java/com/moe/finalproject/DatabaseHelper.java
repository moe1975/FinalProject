package com.moe.finalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Moe on 2017-03-22.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_FILE__NAME = "project.db";
    public static final int DB_VERSION = 001;
    public static String KEY_ID = "_id";
    public static String KEY_MESSAGE = "messages";

    //living room
    /*public static final String TABLE_LIVING_ROOM_ITEMS = "roomItems";
    public static final String COLUMN_LIVING_ROOM_ID = "_id";
    public static final String COLUMN_LIVING_ROOM_DEVICE_TYPE = "deviceType";
    public static final String COLUMN_LIVING_ROOM_DEVICE_TITLE = "deviceTitle";
    public static final String COLUMN_LIVING_ROOM_DEVICE_IMAGE = "deviceImage";
    public static final String COLUMN_LIVING_ROOM_LAST_VISITED = "lastVisited";
    public static final String COLUMN_LIVING_ROOM_CREATED = "created";




    // Database creation sql statement
    private static final String CREATE_LIVING_ROOM_ITEMS_TABLE = "create table "
            + TABLE_LIVING_ROOM_ITEMS + "( "
            + COLUMN_LIVING_ROOM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
            + COLUMN_LIVING_ROOM_DEVICE_TYPE + " int not null default 0, "
            + COLUMN_LIVING_ROOM_DEVICE_TITLE + " text not null, "
            + COLUMN_LIVING_ROOM_DEVICE_IMAGE + " text not null, "
            + COLUMN_LIVING_ROOM_LAST_VISITED + " INTEGER, "
            + COLUMN_LIVING_ROOM_CREATED + " INTEGER);";
            */



    public DatabaseHelper(Context ctx) {
        super(ctx, DB_FILE__NAME , null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ItemsTable.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ItemsTable.SQL_DELETE);
        onCreate(db);
    }
}

    /*@Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_LIVING_ROOM_ITEMS_TABLE);

        Log.i("ChatDatabaseHelper", "Calling onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS messages");
        db.execSQL("drop table if exists"+TABLE_LIVING_ROOM_ITEMS);
        onCreate(db);

        Log.i("DatabaseHelper", "Calling onUpgrade, oldVersion=" + oldVersion + " newVersion=" + newVersion);
    }
}*/