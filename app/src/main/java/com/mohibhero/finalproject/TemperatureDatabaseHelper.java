/**
 * package is com.mohibhero.finalproject.
 */
package com.mohibhero.finalproject;

/**
 * import statments
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * TemperatureDatabaseHelper class used to store the temperature and its id. It is the backbone for the temperature app
 * Idea is taken from Lab 5. Modified to fit the temperature app.
 * Some references from author https://github.com/yass0016. All credits.
 * @author MohibHero
 */
public class TemperatureDatabaseHelper extends SQLiteOpenHelper {

    /**
     * Table name declared in a private static final String.
     */
    public static final String TABLE_MESSAGES = "messages";

    /**
     * Id declared in a private static final String.
     */
    public static final String COLUMN_ID = "_id";

    /**
     * Temperature stored in a private static final String.
     */
    public static final String COLUMN_TEMPERATURE = "temperature";

    /* Database name */
    private static final String DATABASE_NAME = "TemperatureFragment.db";

    /* Version Number */
    private static final int VERSION_NUM = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_MESSAGES + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_TEMPERATURE
            + " text not null);";

    /**
     * Constructor for DatabaseHelper class used to call superclass SQLiteOpenHelper's constructor.
     * @param ctx
     */
    public TemperatureDatabaseHelper(Context ctx) {

        super(ctx, DATABASE_NAME, null, VERSION_NUM);//calling superclass constructor and passing Context, Database Name,
                                                    // SQLite Curson factory and Version Number.

    }

    /**
     * onCreate function used to create database.
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DATABASE_CREATE); //We are creating the Query for creating temperature table as declared above.

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
