/**
 * package is com.mohibhero.finalproject.
 */
package com.mohibhero.finalproject;

/**
 * import statments
 */
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.example.moe.finalproject.R;
import java.util.ArrayList;


/**
 * TemperatureFragment class is also the most important class as the whole Temperature app of House settings run on it.
 * It basically has a list view where we can see the temperature stored, and also delete it from there by clicking and
 * removing.
 * To add the temperature to database and list view we use a text view and button. The idea is taken from Lab 5.
 * Modified and used for temperature.
 * some references from author https://github.com/yass0016. All credits.
 * @author MohibHero
 */
public class TemperatureFragment extends Fragment {

    /**
     * final ArrayList<> variable which has TemperatureData class passed in it.
     */
    final ArrayList<TemperatureData> temperatureArray = new ArrayList<>(); //instantiating a new ArrayList<> object.

    /**
     * private variable for TemperatureDatabaseHelper class.
     */
    private TemperatureDatabaseHelper dbHelper;

    /**
     * private variable for SQLiteDatabase. Used to call the database's methods and activities etc.
     */
    private SQLiteDatabase database;

    /**
     * A string array used to store the columns names of the id and temperature from the temperatureDatabseHelper class.
     */
    private String[] allColumns = { TemperatureDatabaseHelper.COLUMN_ID,
            TemperatureDatabaseHelper.COLUMN_TEMPERATURE };

    /**
     * private variable for TemperatureAdapter class. Used for ListView on the screen.
     */
    private TemperatureAdapter temperatureAdapter;

    /**
     * A Resources variable.
     */
    Resources resources;


    /**
     * A View method which is used to create a view in which we inflate our fragment and insert all our things and
     * program their working. This is important part of the Temperature activity as it is also then used in TemperatureDetails class
     * without explaining everything again for that class hence Code Reuse.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_temperature_fragment, container, false);

        Bundle data = this.getArguments(); //declaring a Bundle object

        dbHelper = new TemperatureDatabaseHelper(getActivity()); //instantiating a new TemperatureDatabaseHelper object passing the Fragment Activity.

        database = dbHelper.getWritableDatabase(); //making the database writeable

        readTemperature(); //calling readTemperature() function.

        resources = getResources(); //putting resources equal to getResources()
        final ListView listViewChat = (ListView) v.findViewById(R.id.listViewChat); //defining the ListView for the Temperature to show and store.
        temperatureAdapter = new TemperatureAdapter(getActivity()); //instantiating a new TemperatureAdapter with The fragment of this activity passed as a parameter.
        listViewChat.setAdapter(temperatureAdapter); //setting the adapter for the list view.
        final EditText editTextChat = (EditText) v.findViewById(R.id.tempInData); //defining the EditText for the Temperature.
        Button buttonSend = (Button) v.findViewById(R.id.addTemprature); //defining the Button for the Temperature to add in Database and list view.

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //do this when the button is clicked.
                String chatString = editTextChat.getText().toString(); //get the Text from the text view and convert it into String
                writeTemperature(chatString); //call the writeMessages() method and pass the string from the text view read in one step earlier.

                editTextChat.setText(""); //after writing the message set the text field in edit text to blank.
            }
        });


        listViewChat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, final int position, final long id) { //do this when the item in the list view is clicked.

                Object o = listViewChat.getItemAtPosition(position); //checking the item at position.
                final TemperatureData str=(TemperatureData)o; //setting the TemperatureData variable to the Object variable.
                Bundle data = new Bundle(); //instantiating a new Bundle object.



                AlertDialog.Builder alertdialog = new AlertDialog.Builder(getActivity()); //creating a new Dialog box.
                alertdialog.setMessage("Do you want to remove the temperature from the database").setCancelable(false) //adding the message to Dialog box.
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) { //set what happens when positive button is clicked.
                                  deleteMessage(id,position ); //use deleteMessage() function and pass the id and position of the message as paramaeters.

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) { //set what happens when negative button is clicked.
                                dialog.cancel(); //cancel the dialog box.
                            }
                        });

                AlertDialog alertDialog = alertdialog.create(); //create the dialog box
                alertDialog.show(); //show the dialog box.

            }
        });

        return v; //return the view.
    }

    /**
     * The readTemperature method contains code to read the temperature stored in database and saves them to the array list
     * so you can view it later i.e. even if you restart the app.
     */
    private void readTemperature() {
        // read database and save temperature into the array list
        Cursor cursor = database.query(TemperatureDatabaseHelper.TABLE_MESSAGES,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst(); //move the cursor to first.
        while (!cursor.isAfterLast()) { //while condition
            String temperature = cursor.getString(cursor.getColumnIndex( TemperatureDatabaseHelper.COLUMN_TEMPERATURE)); //get the temperature

            long id = cursor.getLong(cursor.getColumnIndex(TemperatureDatabaseHelper.COLUMN_ID)); //long variable used to get temperature id.

            TemperatureData data = new TemperatureData(temperature, id); //instantiating a new TemperatureData object and pass the temperature and id as parameters.

            temperatureArray.add(data); //add the id and string to the temperatureArray.

            cursor.moveToNext(); //move the cursor to the next.
        }

        // close the cursor
        cursor.close();
    }

    /**
     * A method to write the temperature to the database and add it to the list view once the button is clicked.
     * @param temperature
     */
    private void writeTemperature(String temperature) {
        ContentValues values = new ContentValues(); //instantiating a new ContentValues object.

        values.put(TemperatureDatabaseHelper.COLUMN_TEMPERATURE, temperature); //put the temperature in database.

        long id = database.insert(TemperatureDatabaseHelper.TABLE_MESSAGES, null, //put the temperature in database.
                values);

        TemperatureData data = new TemperatureData(temperature, id); //instantiating a new TemperatureData object and pass the temperature and id as parameters.

        temperatureAdapter.notifyDataSetChanged(); //notify when any change happens.

        temperatureArray.add(data); //add the data to the temperatureArray.

    }

    /**
     * A method to delete the temperature from the database and the list view once we click Yes button on dialog.
     * @param id
     * @param position
     */
    public void deleteMessage(long id, int position) {
        database.delete(TemperatureDatabaseHelper.TABLE_MESSAGES, "_id=?",
                new String[]{Long.toString(temperatureArray.get(position).get_id())}); //delete the temperature at the given position and remove it's id.

        temperatureArray.remove(position); //remove the temperature from the list view

        temperatureAdapter.notifyDataSetChanged(); //notify when any change happens.

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 5) {
            Bundle extras = data.getExtras();
            int id = Integer.parseInt(extras.getString("id"));

            database.delete(TemperatureDatabaseHelper.TABLE_MESSAGES, "_id=?",
                    new String[]{Long.toString(temperatureArray.get(id).get_id())});

            temperatureArray.remove(id);
            temperatureAdapter.notifyDataSetChanged();
        }
    }

    /**
     * TemperatureAdapter inner class used by the ListView on the screen.
     */
    private class TemperatureAdapter extends ArrayAdapter<TemperatureData> {

        /**
         * TemperatureAdapter constructor where we pass a Context object.
         * @param context
         */
        public TemperatureAdapter(Context context) {

            super(context, 0); //calling the superclass constructor.

        }

        /**
         * A getter used to retrun the size of the temperatureArray ArrayList<>.
         * @return temperatureArray.size().
         */
        public int getCount() {

            return temperatureArray.size(); //returning the size of ArrayList<>.

        }

        /**
         * A getter used to return the position's id of the item in the list view.
         * @param position
         * @return the position's id
         */
        public long getItemId(int position) {

            return temperatureArray.get(position).get_id(); //returning the position's id.

        }

        /**
         * A getter used to return the position of the item in the list view.
         * @param position
         * @return
         */
        public TemperatureData getItem(int position) {

            return temperatureArray.get(position); //return the position.

        }

        /**
         * A getter to inflate the view of the listview with an external layout on top of it.
         * This is an important part of our activity because of this we see our items on the list view.
         * @param position
         * @param convertView
         * @param parent
         * @return
         */
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getActivity().getLayoutInflater(); //LayoutInflater object.
            View result = null; //View object.

            result = inflater.inflate(R.layout.temperature_row_incoming, null); //setting the result to the inflated layout.


            TextView message = (TextView) result.findViewById((R.id.textChat)); //defining the Textview in layout
            message.setText(getItem(position).getTemperature()); //setting the textview with the temperature from getter.
            return result; //returning the result.
        }
    }

    /**
     * onDestroy is used when the app is quit or the system is down.
     */
    @Override
    public void onDestroy() {
        super.onDestroy(); //calling superclass constructor.

        dbHelper.close(); //close the database.
    }
}


