/**
 * package is com.mohibhero.finalproject.
 */
package com.mohibhero.finalproject;

/* Referenced & Idea taken from https://github.com/yass0016
*  All Credits to the author.
*  Modified & Used By : - Mohib Wajid
*/

/**
 * import statments.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * DatabseHelper class which extends SQLiteOpenHelper. Used to create database for House Setting items.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    /* Database name */
    private static final String DATABASE_NAME = "project.db";

    /* Version Number */
    private static final int VERSION_NUM = 1;

    /* House Setting Table */
    public static final String TABLE_HOUSE_ITEMS = "houseItems";

    /* House Settings ID */
    public static final String COLUMN_HOUSE_ID = "_id";

    /* Other columns */
    public static final String COLUMN_OTHER = "other";

    /* Database creation sql statement */
    private static final String CREATE_HOUSE_TABLE = "create table "
            + TABLE_HOUSE_ITEMS + "( " + COLUMN_HOUSE_ID
            + " integer primary key autoincrement, " + COLUMN_OTHER
            + " text not null);";

    /**
     * Constructor for DatabaseHelper class used to call superclass SQLiteOpenHelper's constructor.
     * @param ctx
     */
    public DatabaseHelper(Context ctx) {

        super(ctx, DATABASE_NAME, null, VERSION_NUM); //calling superclass constructor and passing Context, Database Name,
                                                     // SQLite Curson factory and Version Number.

    }

    /**
     * onCreate function used to create database.
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_HOUSE_TABLE); //We are creating the Query for creating house table as declared above.
    }

    /**
     * onUpgradeFunction used if we upgrade the Database's version then it drops and create the table again.
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS messages"); //drop table command
        onCreate(db); //after dropping we can create the same new table.
    }
}