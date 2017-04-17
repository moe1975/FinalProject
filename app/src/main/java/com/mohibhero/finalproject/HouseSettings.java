/**
 * package is com.mohibhero.finalproject.
 */
package com.mohibhero.finalproject;

/**
 * import statements
 */
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.moe.finalproject.R;
import java.util.ArrayList;

/**
 * HouseSettings class extending from Base Activity class. This class is used to implement the House Setting part of the
 * project. It has Garage, Temperature & Weather Forecast apps inside it. All three of these apps are also accessible
 * in landscape mode in Fragments. If we use the phone layout then these activities open on seperate pages.
 * It has a list view where these activities are on the screen and also a toolbar which tells the information about
 * who created the activity i.e. Mohib Wajid.
 * @author MohibHero.
 */
public class HouseSettings extends BaseActivity {

    /**
     * private variabe of ListView. Where we store the activities
     */
    private ListView HouseListView;

    /**
     * private variable of ArrayList<> in which we are accessing things from HouseData class.
     */
    private ArrayList<HouseData> ItemsInHouse;

    /**
     * private variable for HouseAdapter class. Used for ListView on the screen.
     */
    private HouseAdapter HouseAdapter;

    /**
     * private variable for Toolbar used on the top of screen for About information.
     */
    private Toolbar toolbar;

    /**
     * private variable for SQLiteDatabase. Used to call the database's methods and activities etc.
     */
    private SQLiteDatabase db;

    /**
     * onCreate function to create the activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //calling the superclass constructor.

        setContentView(R.layout.activity_house); //setting the content view of the class where the items will appear.

        ItemsInHouse = new ArrayList<>(); //instantiating a new ArrayList<> object for ItemsInHouse.

        toolbar = (Toolbar) findViewById(R.id.house_toolbar); //defining the toolbar used at top of the screen.
        setSupportActionBar(toolbar); //set the support action bar as the toolbar object that is passed inside it.

        HouseListView = (ListView) findViewById(R.id.houseItems); //defining the listview of the class where items will appear.
final boolean isTablet = findViewById(R.id.houseFrame)!= null; //a boolean vairable saying that the framelayout at side of screen (in landscape mode) is not null.

        db = getDbHelper().getWritableDatabase(); //making the database writeable.

        HouseAdapter = new HouseAdapter(this); //instantiating the new HouseAdapter object with HouseSetting class as parameter.

        HouseListView.setAdapter(HouseAdapter); //setting the adapter.

        ItemsInHouse.add(new HouseData(0, "GarageFragment", "@drawable/garage")); //adding the garage class.
        ItemsInHouse.add(new HouseData(1, "TempratureFragment", "@drawable/temperature")); //adding the temperature class.
        ItemsInHouse.add(new HouseData(2, "WeatherForecastFragment", "@drawable/summer")); //adding the weather class.

        HouseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) { //this is what we do if any item on the list view is clicked.
                Object o = HouseListView.getItemAtPosition(position);      //checking the item at position.
                HouseData str = (HouseData) o;                       //setting the HouseData variable to the Object variable.
                Bundle data = new Bundle();                       //instantiating a new Bundle object.

                data.putString("id", Long.toString(id)); //in the bundle put the Id.
                data.putString("itemTitle", ItemsInHouse.get(position).getTitle()); //in the Bundle put the Title
                data.putString("itemImage", ItemsInHouse.get(position).getImageUri()); //in the Bundle put the Image.

                Intent intent = null; //new Intent object declaring.


                if(!isTablet) { //checking if the layout is in tablet(also known landscape mode) or phone mode
                    if (position == 0)
                        intent = new Intent(HouseSettings.this, GarageDetails.class); //start the GarageDetails class

                    else if (position == 1)
                        intent = new Intent(HouseSettings.this, TemperatureDetails.class); //start the TemperatureDetails class
                    else if (position == 2)
                        intent = new Intent(HouseSettings.this, WeatherForecastDetails.class); //start the WeatherForecastDetail class.


                    intent.putExtras(data); //pass the data.
                    startActivity(intent); //start the activity whichever is selected.
                }
                else{
                    Fragment f = null; //new Fragment object declaring.
                    if (position == 0)
                        f = new GarageFragment(); //start the GarageFragment activity in the FrameLayout

                   else if (position == 1)
                       f = new TemperatureFragment(); //start the TemperatureFragment activity in the FrameLayout
                    else if (position == 2)
                        f = new WeatherForecastFragment(); //start the WeatherForecastFragment activity in the FrameLayout


                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction(); //used to begin the Fragment Transaction.


                    ft.replace(R.id.houseFrame, f); //replace the FrameLayout with the activity launched.
                    ft.commit(); //commit the fragment transaction.
                }

            }
        });
    }


    /**
     * HouseAdapter inner class used by the ListView on the screen.
     */
    private class HouseAdapter extends ArrayAdapter<HouseData> {


        /**
         * HouseAdapter constructor where we pass a Context object.
         * @param context
         */
        public HouseAdapter(Context context) {

            super(context, 0); //calling the superclass constructor.

        }


        /**
         * A getter used to retrun the size of the ItemsInHouse ArrayList<>.
         * @return ItemsInHouse.size().
         */
        public int getCount() {

            return ItemsInHouse.size(); //returning the size of ArrayList<>.

        }


        /**
         * A getter used to return the position's id of the item in the list view.
         * @param position
         * @return the position's id.
         */
        public long getItemId(int position) {

            return ItemsInHouse.get(position).get_id(); //returning the position's id.

        }


        /**
         * A getter used to return the position of the item in the list view.
         * @param position
         * @return position.
         */
        public HouseData getItem(int position) {

            return ItemsInHouse.get(position); //return the position.

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
            LayoutInflater inflater = HouseSettings.this.getLayoutInflater(); //LayoutInflater object.
            View result = null; //View object.

            result = inflater.inflate(R.layout.house_settings_data_input, null); //setting the result to the inflated layout.

            TextView HouseItemText = (TextView) result.findViewById((R.id.houseItemText)); //defining the Textview in layout
            HouseItemText.setText(getItem(position).getTitle()); //setting the textview with the title.

            ImageView HouseItemImage = (ImageView) result.findViewById((R.id.houseItemImage)); //defining the ImageView in layout
            HouseItemImage.setImageDrawable(ContextCompat.getDrawable(result.getContext(), getResources().getIdentifier(getItem(position).getImageUri(), null, getPackageName())));
            //setting the imageview with the image

            return result; //returning the result.
        }
    }

    /**
     * The Dialog box method which constructs a new dialog box and set it up with Title, message and a posiive button to cancel the dialog box.
     */
    public void aboutDialog(){ //a dialog box dislpaying about the author of this app and some information on how to use the app.
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(this).setCancelable(false); //creating a new dialog box.
        alertdialog.setTitle("About"); //setting the title.
        alertdialog.setMessage("House Setting app. It contains Garage app, House Temperature app & Weather Forecast." +  //setting the message.
                "\nMade By Mohib Wajid");
        alertdialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { //setting what to do if we click the OK button.
                dialog.cancel(); //cancel the dialog box once Ok button is clicked.
            }
        });

        AlertDialog alertDialog = alertdialog.create(); //creating the dialog box.
        alertDialog.show(); //showing the dialog box.



    }

    /**
     * A method used by toolbar to inflate the menu with the menu we created for the activity.
     * @param m
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu m){
        getMenuInflater().inflate(R.menu.house_toolbar, m); //inflating the menu.
        return true;
    }


    /**
     * A method used by toolbar to give each item on the toolbar a specific function to execute when it is clicked.
     * @param menuItem
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){  //using switch statement.
            case R.id.about: //the id for the item.
                 aboutDialog(); //execute the dialog box.
                return true;
            default: //default used when nothing matches.
                return super.onOptionsItemSelected(menuItem); //calling the super class method.
        }
    }


}
