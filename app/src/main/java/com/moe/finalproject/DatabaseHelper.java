package com.moe.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Moe on 2017-03-22.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    /* Database name and version number */
    private static final String DATABASE_NAME = "project1.db";
    private static final int VERSION_NUM = 1;

    /* Living Room Table and Column Names */
    public static final String TABLE_LIVINGROOM_ITEMS = "roomItems";
    public static final String COLUMN_LIVINGROOM_ID = "_idd";
    public static final String COLUMN_LIVINGROOM_DEVICE_TYPE = "deviceType";
    public static final String COLUMN_LIVINGROOM_DEVICE_TITLE = "deviceTitle";
    public static final String COLUMN_LIVINGROOM_DEVICE_IMAGE = "deviceImage";
    public static final String COLUMN_LIVING_ROOM_LAST_VISITED = "lastVisited";
    public static final String COLUMN_LIVING_ROOM_CREATED = "created";


    //LIGHT1
    public static final String TABLE_LIVINGROOM_LIGHT1_ITEMS = "livingroom_light1_Items";
    public static final String COLUMN_LIVINGROOM_LIGHT1_ID = "_idd";
    public static final String COLUMN_LIVINGROOM_LIGHT1_DEVICE_ID = "_device_id";
    public static final String COLUMN_LIVINGROOM_LIGHT1_DEVICE_STATUS = "device_L1_Status";

    //LIGHT2
    public static final String TABLE_LIVINGROOM_LIGHT2_ITEMS = "livingroom_light2_Items";
    public static final String COLUMN_LIVINGROOM_LIGHT2_ID = "_idd";
    public static final String COLUMN_LIVINGROOM_LIGHT2_DEVICE_ID = "_device_id";
    public static final String COLUMN_LIVINGROOM_LIGHT2_DEVICE_STATUS = "device_L2_Status";
    public static final String COLUMN_LIVINGROOM_LIGHT2_DEVICE_DIM_LEVEL = "device_L2_dimlevel";

    //LIGHT3
    public static final String TABLE_LIVINGROOM_LIGHT3_ITEMS = "livingroom_light3_Items";
    public static final String COLUMN_LIVINGROOM_LIGHT3_ID = "_idd";
    public static final String COLUMN_LIVINGROOM_LIGHT3_DEVICE_ID = "_device_id";
    public static final String COLUMN_LIVINGROOM_LIGHT3_DEVICE_STATUS = "device_L3_Status";
    public static final String COLUMN_LIVINGROOM_LIGHT3_DEVICE_COLOR = "device_L3_Color";
    public static final String COLUMN_LIVINGROOM_LIGHT3_DEVICE_DIM_LEVEL = "device_L3_dimlevel";


    //BLINDING
    public static final String TABLE_LIVINGROOM_BLINDING_ITEMS = "livingroom_blinds";
    public static final String COLUMN_LIVINGROOM_BLINDING_ID = "_idd";
    public static final String COLUMN_LIVINGROOM_BLINDING_DEVICE_ID = "_device_id";
    public static final String COLUMN_LIVINGROOM_BLINDING_DEVICE_STATUS = "device_BL_Status";


    //TV
    public static final String TABLE_LIVINGROOM_TV_ITEMS = "livingroom_tv";
    public static final String COLUMN_LIVINGROOM_TV_ID = "_idd";
    public static final String COLUMN_LIVINGROOM_TV_DEVICE_ID = "_device_id";



    //TV CHANNEL
    public static final String TABLE_LIVINGROOM_TV_CHANNEL = "livingroom_tv_channel";
    public static final String COLUMN_LIVINGROOM_TV_CHANNELS = "device_TV_Channels";
    public static final String COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_ID = "_idd";
    public static final String COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_DEVICE_ID = "device_id";
    public static final String COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NUMBER = "device_TV_channel_Number";
    public static final String COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NAME = "device_TV_channel_Name";
    public static final String COLUMN_LIVINGROOM_TV_DEVICE_VOLUME = "device_TV_volume";


    // Database creation sql statement
    private static final String CREATE_ROOM_ITEMS_TABLE = "create table "
            + TABLE_LIVINGROOM_ITEMS + "( "
            + COLUMN_LIVINGROOM_ID + " integer primary key autoincrement not null, "
            + COLUMN_LIVINGROOM_DEVICE_TYPE + " integer default 0, "
            + COLUMN_LIVINGROOM_DEVICE_TITLE + " text, "
            + COLUMN_LIVINGROOM_DEVICE_IMAGE + " text not null, "
            + COLUMN_LIVING_ROOM_LAST_VISITED + " integer, "
            + COLUMN_LIVING_ROOM_CREATED + " integer);";

    //LIGHT1
    private static final String CREATE_TABLE_LIGHT1 = "create table "
            + TABLE_LIVINGROOM_LIGHT1_ITEMS + "( "
            + COLUMN_LIVINGROOM_LIGHT1_ID + " integer primary key autoincrement not null, "
            + COLUMN_LIVINGROOM_LIGHT1_DEVICE_ID + " integer, "
            + COLUMN_LIVINGROOM_LIGHT1_DEVICE_STATUS + " integer default 0);";

    //LIGHT2
    private static final String CREATE_TABLE_LIGHT2 = "create table "
            + TABLE_LIVINGROOM_LIGHT2_ITEMS + "( "
            + COLUMN_LIVINGROOM_LIGHT2_ID + " integer primary key autoincrement not null, "
            + COLUMN_LIVINGROOM_LIGHT2_DEVICE_STATUS + " integer default 0, "
            + COLUMN_LIVINGROOM_LIGHT2_DEVICE_ID + " integer, "
            + COLUMN_LIVINGROOM_LIGHT2_DEVICE_DIM_LEVEL + " integer);";


    //LIGHT3
    private static final String CREATE_TABLE_LIGHT3 = "create table "
            + TABLE_LIVINGROOM_LIGHT3_ITEMS + "( "
            + COLUMN_LIVINGROOM_LIGHT3_ID + " integer primary key autoincrement not null, "
            + COLUMN_LIVINGROOM_LIGHT3_DEVICE_STATUS + " integer default 0, "
            + COLUMN_LIVINGROOM_LIGHT3_DEVICE_ID + " integer, "
            + COLUMN_LIVINGROOM_LIGHT3_DEVICE_COLOR + " integer default 0, "
            + COLUMN_LIVINGROOM_LIGHT3_DEVICE_DIM_LEVEL + " integer);";


    //BLINDING
    private static final String CREATE_TABLE_BLINDING = "create table "
            + TABLE_LIVINGROOM_BLINDING_ITEMS + "( "
            + COLUMN_LIVINGROOM_BLINDING_ID + " integer primary key autoincrement not null, "
            + COLUMN_LIVINGROOM_BLINDING_DEVICE_ID + " integer, "
            + COLUMN_LIVINGROOM_BLINDING_DEVICE_STATUS + " integer default 0);";

    //TV
    private static final String CREATE_TABLE_TV = "create table "
            + TABLE_LIVINGROOM_TV_ITEMS + "( "
            + COLUMN_LIVINGROOM_TV_ID + " integer primary key autoincrement not null, "
            + COLUMN_LIVINGROOM_TV_DEVICE_ID + " integer);";

    //TV CHANNELS
    private static final String CREATE_TABLE_TV_CHANNEL = "create table "
            + TABLE_LIVINGROOM_TV_CHANNEL + "( "
            + COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_ID + " integer primary key autoincrement not null, "
            + COLUMN_LIVINGROOM_TV_DEVICE_VOLUME + " integer, "
            + COLUMN_LIVINGROOM_TV_CHANNELS + " integer, "
            + COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_DEVICE_ID + " integer, "
            + COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NUMBER + " integer default 0, "
            + COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NAME + " integer default 0);";


    public DatabaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ROOM_ITEMS_TABLE);
        db.execSQL(CREATE_TABLE_BLINDING);
        db.execSQL(CREATE_TABLE_LIGHT1);
        db.execSQL(CREATE_TABLE_LIGHT2);
        db.execSQL(CREATE_TABLE_LIGHT3);
        db.execSQL(CREATE_TABLE_TV);
        db.execSQL(CREATE_TABLE_TV_CHANNEL);
        Log.i("ChatDatabaseHelper", "Calling onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS messages");
        onCreate(db);

        Log.i("DatabaseHelper", "Calling onUpgrade, oldVersion=" + oldVersion + " newVersion=" + newVersion);
    }

    public long insertLivingRoomItem(int device_type, String image) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues room_item_values = new ContentValues();
        room_item_values.put(COLUMN_LIVINGROOM_DEVICE_TYPE, device_type);
        room_item_values.put(COLUMN_LIVINGROOM_DEVICE_IMAGE, image);
        long _id = db.insert(TABLE_LIVINGROOM_ITEMS, null, room_item_values);

        room_item_values = new ContentValues();
        room_item_values.put(COLUMN_LIVINGROOM_LIGHT1_DEVICE_ID, _id);
        db.insert(TABLE_LIVINGROOM_LIGHT1_ITEMS, null, room_item_values);

        room_item_values = new ContentValues();
        room_item_values.put(COLUMN_LIVINGROOM_LIGHT2_DEVICE_ID, _id);
        db.insert(TABLE_LIVINGROOM_LIGHT2_ITEMS, null, room_item_values);

        room_item_values = new ContentValues();
        room_item_values.put(COLUMN_LIVINGROOM_LIGHT3_DEVICE_ID, _id);
        db.insert(TABLE_LIVINGROOM_LIGHT3_ITEMS, null, room_item_values);

        room_item_values = new ContentValues();
        room_item_values.put(COLUMN_LIVINGROOM_TV_DEVICE_ID, _id);
        db.insert(TABLE_LIVINGROOM_TV_ITEMS, null, room_item_values);

        room_item_values = new ContentValues();
        room_item_values.put(COLUMN_LIVINGROOM_BLINDING_DEVICE_ID, _id);
        db.insert(TABLE_LIVINGROOM_BLINDING_ITEMS, null, room_item_values);

        room_item_values = new ContentValues();
        room_item_values.put(COLUMN_LIVINGROOM_TV_DEVICE_ID, _id);
        room_item_values.put(COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NUMBER, 1);
        db.insert(TABLE_LIVINGROOM_TV_CHANNEL, null, room_item_values);

        room_item_values = new ContentValues();
        room_item_values.put(COLUMN_LIVINGROOM_TV_DEVICE_ID, _id);
        room_item_values.put(COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NUMBER, 2);
        db.insert(TABLE_LIVINGROOM_TV_CHANNEL, null, room_item_values);

        room_item_values = new ContentValues();
        room_item_values.put(COLUMN_LIVINGROOM_TV_DEVICE_ID, _id);
        room_item_values.put(COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NUMBER, 3);
        db.insert(TABLE_LIVINGROOM_TV_CHANNEL, null, room_item_values);

        room_item_values = new ContentValues();
        room_item_values.put(COLUMN_LIVINGROOM_TV_DEVICE_ID, _id);
        room_item_values.put(COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NUMBER, 4);
        db.insert(TABLE_LIVINGROOM_TV_CHANNEL, null, room_item_values);

        room_item_values = new ContentValues();
        room_item_values.put(COLUMN_LIVINGROOM_TV_DEVICE_ID, _id);
        room_item_values.put(COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NUMBER, 5);
        db.insert(TABLE_LIVINGROOM_TV_CHANNEL, null, room_item_values);

        room_item_values = new ContentValues();
        room_item_values.put(COLUMN_LIVINGROOM_TV_DEVICE_ID, _id);
        room_item_values.put(COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NUMBER, 6);
        db.insert(TABLE_LIVINGROOM_TV_CHANNEL, null, room_item_values);


        return _id;
    }



    public void saveLivingRoomItemCount(long device_id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_LIVINGROOM_ITEMS + " WHERE " + COLUMN_LIVINGROOM_ID + "=?", new String[]{Long.toString(device_id)});

        int count = 0;

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            count = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LIVING_ROOM_LAST_VISITED));

            cursor.moveToNext();
        }

        count += 1;

        db = getWritableDatabase();
        ContentValues livingroom_value = new ContentValues();
        livingroom_value.put(COLUMN_LIVING_ROOM_LAST_VISITED, count);
        db.update(TABLE_LIVINGROOM_ITEMS, livingroom_value, COLUMN_LIVINGROOM_ID + "=?", new String[]{Long.toString(device_id)});
    }


    public void saveL1status(int livingroom_light1, long device_id) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues livingroom_l1_value = new ContentValues();
        livingroom_l1_value.put(COLUMN_LIVINGROOM_LIGHT1_DEVICE_STATUS, livingroom_light1);
        db.update(TABLE_LIVINGROOM_LIGHT1_ITEMS, livingroom_l1_value, COLUMN_LIVINGROOM_LIGHT1_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});

    }


    public void saveL2status(int livingroom_light2, long device_id) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues livingroom_l2_value = new ContentValues();
        livingroom_l2_value.put(COLUMN_LIVINGROOM_LIGHT2_DEVICE_STATUS, livingroom_light2);
        db.update(TABLE_LIVINGROOM_LIGHT2_ITEMS, livingroom_l2_value, COLUMN_LIVINGROOM_LIGHT2_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});


    }

    public void saveL3status(int livingroom_light3, long device_id) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues livingroom_l3_value = new ContentValues();
        livingroom_l3_value.put(COLUMN_LIVINGROOM_LIGHT3_DEVICE_STATUS, livingroom_light3);
        db.update(TABLE_LIVINGROOM_LIGHT3_ITEMS, livingroom_l3_value, COLUMN_LIVINGROOM_LIGHT3_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});

    }

    public void saveBlindingstatus(int livingroom_blinding, long device_id) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues livingroom_bl_value = new ContentValues();
        livingroom_bl_value.put(COLUMN_LIVINGROOM_BLINDING_DEVICE_STATUS, livingroom_blinding);
        db.update(TABLE_LIVINGROOM_BLINDING_ITEMS, livingroom_bl_value, COLUMN_LIVINGROOM_BLINDING_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});
    }

    public void savetvchannelnumber(int channel_number, int channel_name, long device_id) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues tv_channel_values = new ContentValues();
        tv_channel_values.put(COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NAME, channel_name);
        db.execSQL("UPDATE " + TABLE_LIVINGROOM_TV_CHANNEL + " SET " + COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NAME + "=" + channel_name + " WHERE " + COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_ID + "=" + device_id + " AND " + COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NUMBER + "=" + channel_number + ";");
    }

    /*public void saveTVstatus(String livingroom_TV, long device_id) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues livingroom_tv_value = new ContentValues();
        livingroom_tv_value.put(COLUMN_LIVINGROOM_TV_DEVICE_STATUS, livingroom_TV);
        db.update(TABLE_LIVINGROOM_TV_ITEMS, livingroom_tv_value, COLUMN_LIVINGROOM_TV_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});

    }*/



    public Cursor getL1status(long device_id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_LIVINGROOM_LIGHT1_ITEMS + " WHERE " + COLUMN_LIVINGROOM_LIGHT1_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});
        return cursor;
    }

    public Cursor getL2status(long device_id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_LIVINGROOM_LIGHT2_ITEMS + " WHERE " + COLUMN_LIVINGROOM_LIGHT2_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});
        return cursor;
    }

    public Cursor getL3status(long device_id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_LIVINGROOM_LIGHT3_ITEMS + " WHERE " + COLUMN_LIVINGROOM_LIGHT3_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});
        return cursor;
    }

    public Cursor getBlindingstatus(long device_id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_LIVINGROOM_BLINDING_ITEMS + " WHERE " + COLUMN_LIVINGROOM_BLINDING_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});
        return cursor;
    }

    public Cursor getTVstatus(long device_id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_LIVINGROOM_TV_ITEMS + " WHERE " + COLUMN_LIVINGROOM_TV_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});
        return cursor;
    }

    public Cursor getLivingroom_Items() {

        SQLiteDatabase db = this.getReadableDatabase();
//      Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_LIVINGROOM_ITEMS, null);
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_LIVINGROOM_ITEMS +
                " ORDER BY " + COLUMN_LIVING_ROOM_LAST_VISITED + " DESC", null);

        return cursor;
    }

    public Cursor getChannelName(int channel_number, long device_id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_LIVINGROOM_TV_CHANNEL + " WHERE "
                + COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_DEVICE_ID + "=?" + " AND "
                + COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NUMBER + "=?", new String[]{Long.toString(device_id), Integer.toString(channel_number)});
        return cursor;
    }


    public void deletlivingroomiteam(long device_id) {

        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_LIVINGROOM_ITEMS, COLUMN_LIVINGROOM_ID + "=?", new String[]{Long.toString(device_id)});
    }

    public void saveL2dimlevel(long device_id, int light2_dimlevel) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues livingroom_l2_value = new ContentValues();
        livingroom_l2_value.put(COLUMN_LIVINGROOM_LIGHT2_DEVICE_DIM_LEVEL, light2_dimlevel);
        db.update(TABLE_LIVINGROOM_LIGHT2_ITEMS, livingroom_l2_value, COLUMN_LIVINGROOM_LIGHT2_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});


    }

    public void saveL3dimlevel(long device_id, int light3_dimlevel) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues livingroom_l3_value = new ContentValues();
        livingroom_l3_value.put(COLUMN_LIVINGROOM_LIGHT3_DEVICE_DIM_LEVEL, light3_dimlevel);
        db.update(TABLE_LIVINGROOM_LIGHT3_ITEMS, livingroom_l3_value, COLUMN_LIVINGROOM_LIGHT3_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});
    }

    public void saveL3color(long device_id, int light3_color) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues livingroom_l3_value = new ContentValues();
        livingroom_l3_value.put(COLUMN_LIVINGROOM_LIGHT3_DEVICE_COLOR, light3_color);
        db.update(TABLE_LIVINGROOM_LIGHT3_ITEMS, livingroom_l3_value, COLUMN_LIVINGROOM_LIGHT3_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});
    }

    /*public void savetvChannel_1(long device_id, int channel_1) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues livingroom_tvChannel_value = new ContentValues();
        livingroom_tvChannel_value.put(COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NUMBER1, channel_1);
        db.update(TABLE_LIVINGROOM_TV_ITEMS, livingroom_tvChannel_value, COLUMN_LIVINGROOM_TV_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});
    }

    public void savetvChannel_2(long device_id, int channel_2) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues livingroom_tvChannel_value = new ContentValues();
        livingroom_tvChannel_value.put(COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NUMBER2, channel_2);
        db.update(TABLE_LIVINGROOM_TV_ITEMS, livingroom_tvChannel_value, COLUMN_LIVINGROOM_TV_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});
    }

    public void savetvChannel_3(long device_id, int channel_3) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues livingroom_tvChannel_value = new ContentValues();
        livingroom_tvChannel_value.put(COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NUMBER3, channel_3);
        db.update(TABLE_LIVINGROOM_TV_ITEMS, livingroom_tvChannel_value, COLUMN_LIVINGROOM_TV_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});
    }

    public void savetvChannel_4(long device_id, int channel_4) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues livingroom_tvChannel_value = new ContentValues();
        livingroom_tvChannel_value.put(COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NUMBER4, channel_4);
        db.update(TABLE_LIVINGROOM_TV_ITEMS, livingroom_tvChannel_value, COLUMN_LIVINGROOM_TV_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});
    }

    public void savetvChannel_5(long device_id, int channel_5) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues livingroom_tvChannel_value = new ContentValues();
        livingroom_tvChannel_value.put(COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NUMBER5, channel_5);
        db.update(TABLE_LIVINGROOM_TV_ITEMS, livingroom_tvChannel_value, COLUMN_LIVINGROOM_TV_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});
    }

    public void savetvChannel_6(long device_id, int channel_6) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues livingroom_tvChannel_value = new ContentValues();
        livingroom_tvChannel_value.put(COLUMN_LIVINGROOM_TV_DEVICE_CHANNEL_NUMBER6, channel_6);
        db.update(TABLE_LIVINGROOM_TV_ITEMS, livingroom_tvChannel_value, COLUMN_LIVINGROOM_TV_DEVICE_ID + "=?", new String[]{Long.toString(device_id)});
    }*/


}