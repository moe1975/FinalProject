/**
 * package is com.mohibhero.finalproject.
 */
package com.mohibhero.finalproject;

/* Referenced from https://github.com/yass0016
*  All Credits to the author.
*  Used By : - Mohib Wajid
*/

/**
 * import statments.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Base Activity class extending from AppCompatActivity. Used to create new DatabaseHelper object.
 */
public class BaseActivity extends AppCompatActivity {
    /**
     * DatabaseHelper class's object defining.
     */
    DatabaseHelper dbHelper;

    /**
     * onCreate function used to create the activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //calling super class's onCreate function.
        dbHelper = new DatabaseHelper(this); //instantiating a new DatabaseHelper object where we pass BaseActivity as a parameter
    }

    /**
     * A getter function which returns the DatabaseHelper object.
     * @return dbHelper (DatabaseHelper)
     */
    public DatabaseHelper getDbHelper() {
        return  dbHelper; //getter function used to return DatabaseHelper object.
    }

}

